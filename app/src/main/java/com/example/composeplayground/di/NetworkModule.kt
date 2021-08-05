package com.example.composeplayground.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {
    fun createOkHttpClient(): OkHttpClient {
        val timeout = 60L
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        return OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    inline fun <reified T> createApi(
        servicePath: String,
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl + servicePath)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(T::class.java)
    }
}