package com.p_f

import io.kvision.core.AlignItems
import io.kvision.core.FontStyle
import io.kvision.core.*
import io.kvision.form.check.RadioGroup
import io.kvision.form.check.radioGroup
import io.kvision.html.*
import io.kvision.form.text.TextInput
import io.kvision.form.text.text
import io.kvision.i18n.I18n
import io.kvision.modal.Confirm
import io.kvision.panel.SimplePanel
import io.kvision.panel.hPanel
import io.kvision.state.bind
import io.kvision.table.HeaderCell
import io.kvision.table.TableType
import io.kvision.table.cell
import io.kvision.table.row
import io.kvision.table.table
import io.kvision.utils.px

object UserAddress : SimplePanel() {

    init {
        padding = 10.px

        hPanel(alignItems = AlignItems.CENTER, spacing = 20) {
            text(InputType.SEARCH) {
                placeholder = "${I18n.tr("Suche")} ..."
                setEventListener<TextInput> {
                    input = {
                        Model.search = self.value
                    }
                }
            }
        }

        table(types = setOf(TableType.STRIPED, TableType.HOVER)) {
            addHeaderCell(this@UserAddress.sortingHeaderCell(I18n.tr("Vorname"), Sort.FN))
            addHeaderCell(this@UserAddress.sortingHeaderCell(I18n.tr("Nachname"), Sort.LN))
            addHeaderCell(this@UserAddress.sortingHeaderCell(I18n.tr("E-mail"), Sort.E))
            addHeaderCell(HeaderCell(""))
            bind(Model.userAddress) { addresses ->
                addresses.forEachIndexed { index, address ->
                    row {
                        cell(address.firstName)
                        cell(address.lastName)
                        cell {
                            address.email?.let {
                                link(it, "mailto:$it") {
                                    fontStyle = FontStyle.ITALIC
                                }
                            }
                        }
                        cell(address.phone)
                        cell(address.postalAddress)
                        cell(address.bio)
                        cell {
                            icon("fas fa-times") {
                                title = I18n.tr("Löschen")
                                onEvent {
                                    click = { e ->
                                        e.stopPropagation()
                                        Confirm.show("Bist Du Dir sicher??", "Möchtest Du wirklich diese Anschrift und Benutzer löschen?") {
                                            UserSettingPanel.delete(index)
                                        }
                                    }
                                }
                            }
                        }
                        cell {
                            icon("fas fa-gear") {
                                title = I18n.tr("Bearbeiten")
                                onEvent {
                                    click = { e ->
                                        UserSettingPanel.edit(index)
                                    }
                                }
                            }
                        }
                        onEvent {
                            click = {
                                UserSettingPanel.edit(index)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun sortingHeaderCell(title: String, sort: Sort) = HeaderCell(title) {
        onEvent {
            click = {
                Model.sort = sort
            }
        }
    }
}