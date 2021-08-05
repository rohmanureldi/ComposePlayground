package com.example.composeplayground.data

import com.example.composeplayground.data.remote.api.CatApi
import com.example.composeplayground.data.remote.api.RecipeApi
import com.google.gson.JsonObject
import javax.inject.Inject

class ApiDataStore @Inject constructor(
    private val catApi: CatApi,
    private val recipeApi: RecipeApi
) : ApiRepo{

    override suspend fun getCatBreeds(): JsonObject {
        return catApi.getCatBreed()
    }

    override suspend fun searchRecipe(page: Int, query: String?): JsonObject {
        return recipeApi.searchRecipe(
            page = page,
            query = query
        )
    }
}