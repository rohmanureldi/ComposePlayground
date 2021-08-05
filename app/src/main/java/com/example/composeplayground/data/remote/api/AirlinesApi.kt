package com.example.composeplayground.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface AirlinesApi {

    @GET("https://api.instantwebtools.net/v1/passenger?page=2&size=10")
    fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    )
}