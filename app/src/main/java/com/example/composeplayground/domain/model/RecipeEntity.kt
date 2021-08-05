package com.example.composeplayground.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeEntity(
    @PrimaryKey val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val featured_image: String = "",
    val ingredients: List<String> = emptyList()
)