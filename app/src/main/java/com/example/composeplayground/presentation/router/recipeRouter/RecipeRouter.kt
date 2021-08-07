package com.example.composeplayground.presentation.router.recipeRouter

enum class RecipeRouter(val route: String, val argsParam: String = "") {
    RECIPE_HOME("recipeHome"),
    RECIPE_LIST("recipeList"),
    RECIPE_DETAIL("recipeDetail", "/{recipeId}")
}