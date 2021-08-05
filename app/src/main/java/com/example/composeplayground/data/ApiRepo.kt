package com.example.composeplayground.data

import com.example.composeplayground.data.model.RecipeItem
import com.example.composeplayground.data.remote.ApiResponse
import com.google.gson.JsonObject

interface ApiRepo {
    suspend fun getCatBreeds(): JsonObject

    suspend fun searchRecipe(page: Int, query: String? = null): JsonObject
}