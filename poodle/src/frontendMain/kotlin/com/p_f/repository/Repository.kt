package com.p_f.repository

import com.p_f.repository.auth.authRepositoryModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(authRepositoryModule)
}