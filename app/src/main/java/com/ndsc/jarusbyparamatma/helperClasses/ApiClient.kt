package com.ndsc.jarusbyparamatma.helperClasses

import com.ndsc.jarusbyparamatma.helperClasses.ApiRequest.Companion.Base_URl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private val timeUnit = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    fun getClient() : ApiRequest {
        return Retrofit.Builder()
            .baseUrl(Base_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(timeUnit)
            .build()
            .create(ApiRequest::class.java)
    }
}