package com.ex.kriptcur.network.networking

import com.ex.kriptcur.network.dto.BitcoinResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinAPI {
    @GET("v1/cryptocurrency/listings/latest")
    fun getRatesAsync(
    ): Deferred<Response<BitcoinResponse>>
}