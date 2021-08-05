package com.example.composeplayground.di

import com.example.composeplayground.BuildConfig
import com.example.composeplayground.data.remote.api.CatApi
import com.example.composeplayground.data.remote.api.RecipeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        return NetworkModule.createOkHttpClient()
    }

    @Singleton
    @Provides
    fun createApi(okHttpClient: OkHttpClient): CatApi {
        return NetworkModule.createApi("", okHttpClient, BuildConfig.BASE_URL)
    }

    @Singleton
    @Provides
    fun createRecipeApi(okHttpClient: OkHttpClient): RecipeApi {
        return NetworkModule.createApi("", okHttpClient, BuildConfig.RECIPE_API)
    }

}