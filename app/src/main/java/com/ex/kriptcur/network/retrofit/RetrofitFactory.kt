package com.ex.kriptcur.network.retrofit

import com.ex.kriptcur.network.networking.BitcoinAPI
import com.ex.kriptcur.network.utils.DataConst.BASE_URL
import com.ex.kriptcur.network.utils.DataConst.KEY_NAME
import com.ex.kriptcur.network.utils.DataConst.KEY_VALUE
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(Interceptor { chain ->
            val req = chain
                .request()
                .newBuilder()
                .addHeader(KEY_NAME, KEY_VALUE)
                .build()
            chain.proceed(req)
        })

    fun getRetrofit(): BitcoinAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client .build())
            .build()
            .create()


    }

}