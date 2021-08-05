package com.example.composeplayground.data.remote.api

import com.google.gson.JsonObject
import retrofit2.http.GET

interface CatApi {

    @GET("breeds")
    suspend fun getCatBreed(): JsonObject
}