package com.example.composeplayground.data.local

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.composeplayground.data.model.RecipeItem

@Dao
interface RecipeDao {
    @Insert(onConflict = REPLACE)
    fun saveRecipe(recipe: RecipeItem)

    @Insert(onConflict = REPLACE)
    fun saveAllRecipe(recipes: List<RecipeItem>)

    @Query("SELECT * FROM recipeentity WHERE id = :recipeId")
    fun loadById(recipeId: Int): MutableState<RecipeItem>
}