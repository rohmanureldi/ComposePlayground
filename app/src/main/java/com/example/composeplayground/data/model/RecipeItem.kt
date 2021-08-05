package com.example.composeplayground.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class RecipeItem(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("featured_image")
    val featured_image: String = "",

    @SerializedName("ingredients")
    val ingredients: List<String> = emptyList()
)
