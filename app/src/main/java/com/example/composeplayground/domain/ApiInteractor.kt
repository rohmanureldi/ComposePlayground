package com.example.composeplayground.domain

import com.example.composeplayground.data.ApiRepo
import com.example.composeplayground.domain.model.CatBreed
import com.example.composeplayground.domain.model.RecipeEntity
import javax.inject.Inject

class ApiInteractor @Inject constructor(private val repo: ApiRepo): ApiUsecase {
    override suspend fun getCatBreeds(): List<CatBreed> {
        return repo.getCatBreeds()["data"]?.asJsonArray?.map {
            CatBreed(
                breed = it.asJsonObject["breed"]?.asString.orEmpty(),
                country = it.asJsonObject["country"]?.asString.orEmpty(),
                origin = it.asJsonObject["origin"]?.asString.orEmpty(),
                coat = it.asJsonObject["coat"]?.asString.orEmpty(),
                pattern = it.asJsonObject["pattern"]?.asString.orEmpty()
            )
        }.orEmpty()
    }

    override suspend fun searchRecipe(page: Int, query: String): List<RecipeEntity> {
        return repo.searchRecipe(
            page = page,
            query = query
        )["results"]?.asJsonArray?.map {
            val data = it.asJsonObject
            RecipeEntity(
                id = data["pk"]?.asInt ?: -1,
                title = data["title"]?.asString.orEmpty(),
                featured_image = data["featured_image"]?.asString.orEmpty(),
                description = data["description"]?.asString.orEmpty(),
                ingredients = data["ingredients"]?.asJsonArray?.map { it.asString }.orEmpty()
            )
        }.orEmpty()
    }
}