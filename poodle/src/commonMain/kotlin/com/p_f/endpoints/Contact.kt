package com.p_f.endpoints

import arrow.core.Either
import com.p_f.dto.*
import com.p_f.error.ApiError
import io.kvision.annotations.KVService

@KVService
interface IContactEndpointService {
    suspend fun list(): Result<ApiDataResource<List<ContactDto>>>
    suspend fun findByUid(uid: String): Result<ApiDataResource<ContactDto>>
    suspend fun create(data: CreateContactDto): Result<ApiDataResource<EntityUid>>
    suspend fun update(uid: String, data: UpdateContactDto): Result<ApiDataResource<EntityUid>>
    suspend fun delete(uid: String): Result<ApiDataResource<EntityUid>>
}