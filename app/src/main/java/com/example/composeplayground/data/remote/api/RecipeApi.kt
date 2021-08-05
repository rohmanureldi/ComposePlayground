package com.example.composeplayground.data.remote.api

import com.example.composeplayground.data.model.RecipeItem
import com.example.composeplayground.data.remote.ApiResponse
import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {

    @GET("search/")
    suspend fun searchRecipe(
        @Header("Authorization") token: String = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
        @Query("page") page: Int,
        @Query("query") query: String? = null
    ): JsonObject
}