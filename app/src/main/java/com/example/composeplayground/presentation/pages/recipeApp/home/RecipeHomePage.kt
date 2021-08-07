package com.example.composeplayground.presentation.pages.recipeApp.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.presentation.MainViewModel
import com.example.composeplayground.presentation.router.recipeRouter.RecipeRouter
import com.example.composeplayground.presentation.pages.recipeApp.RecipeDetailPage
import com.example.composeplayground.presentation.pages.recipeApp.RecipeListPage


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun RecipeHomePage(
    recipeVm: MainViewModel
) {
    val recipeNav = rememberNavController()

    NavHost(
        navController = recipeNav,
        startDestination = RecipeRouter.RECIPE_LIST.route
    ) {
        composable(RecipeRouter.RECIPE_LIST.route) {
            RecipeListPage(
                navController = recipeNav,
                vm = recipeVm
            )
        }

        composable(
            route = RecipeRouter.RECIPE_DETAIL.route + RecipeRouter.RECIPE_DETAIL.argsParam
        ) {
            RecipeDetailPage(
                recipe = recipeVm.clickedRecipe.value
            )
        }
    }
}