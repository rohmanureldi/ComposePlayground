package com.example.composeplayground.presentation.router

import com.example.composeplayground.presentation.router.airlinesRouter.AirlinesRouter
import com.example.composeplayground.presentation.router.recipeRouter.RecipeRouter

object RouterModule {
    fun getModulesHome(): Map<String, String> {
        return mapOf(
            "Recipe App" to RecipeRouter.RECIPE_HOME.route,
            "Airlines App" to AirlinesRouter.HOME.route
        )
    }
}