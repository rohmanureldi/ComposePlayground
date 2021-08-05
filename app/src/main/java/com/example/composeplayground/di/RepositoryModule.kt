package com.example.composeplayground.di

import com.example.composeplayground.data.ApiDataStore
import com.example.composeplayground.data.ApiRepo
import com.example.composeplayground.data.remote.api.CatApi
import com.example.composeplayground.data.remote.api.RecipeApi
import com.example.composeplayground.domain.ApiInteractor
import com.example.composeplayground.domain.ApiUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun getApiRepo(catApi: CatApi, recipeApi: RecipeApi): ApiRepo {
        return ApiDataStore(catApi, recipeApi)
    }

    @Provides
    @Singleton
    fun getApiUsecase(repo: ApiRepo): ApiUsecase {
        return ApiInteractor(repo)
    }
}

