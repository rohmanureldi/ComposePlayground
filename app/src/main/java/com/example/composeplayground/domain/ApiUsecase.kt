package com.example.composeplayground.domain

import com.example.composeplayground.domain.model.CatBreed
import com.example.composeplayground.domain.model.RecipeEntity

interface ApiUsecase {
    suspend fun getCatBreeds(): List<CatBreed>

    suspend fun searchRecipe(page: Int, query: String): List<RecipeEntity>
}