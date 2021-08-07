package com.example.composeplayground.presentation.pages.recipeApp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeplayground.domain.model.RecipeEntity
import com.example.composeplayground.domain.model.UIState
import com.example.composeplayground.presentation.MainViewModel
import com.example.composeplayground.presentation.components.EmptyListComponent
import com.example.composeplayground.presentation.components.IndeterminateCircularLoading
import com.example.composeplayground.presentation.components.RecipeCard
import com.example.composeplayground.presentation.components.SearchActionBar
import com.example.composeplayground.presentation.router.recipeRouter.RecipeRouter
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun RecipeListPage(
    navController: NavController,
    vm: MainViewModel
) {
    val searchBarVisibility = vm.testingVisibility.value

    val recipeList = vm.recipeList.value

    ComposePlaygroundTheme {
        Column {
            SearchActionBar(
                inputValue = vm.query.value,
                onValueChange = {
                    vm.onQueryChanged(it)
                },
                onImeActionClicked = {
                    vm.searchRecipe()
                },
                visible = searchBarVisibility,
                changeVisibility = {
                    vm.changeVisibiliity()
                },
            )

            when (recipeList) {
                is UIState.Default -> {
                }
                is UIState.Error -> {
                    EmptyListComponent()
                }
                is UIState.Loading -> {
                    IndeterminateCircularLoading()
                }
                is UIState.Sucess -> {
                    if (recipeList.data.isNotEmpty()) {
                        ShowRecipeList(
                            recipeList = recipeList.data,
                            navController = navController
                        ) {
                            vm.clickedRecipe.value = it
                        }
                    } else {
                        EmptyListComponent()
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun ShowRecipeList(
    recipeList: List<RecipeEntity>,
    navController: NavController,
    onRecipeClick: (RecipeEntity) -> Unit
) {
    LazyColumn(
        Modifier
            .padding(start = 12.dp, end = 12.dp)
    ) {
        itemsIndexed(
            items = recipeList
        ) { _: Int, recipe: RecipeEntity ->
            RecipeCard(
                recipe = recipe,
            ) {
                onRecipeClick(recipe)
                navController.navigate(RecipeRouter.RECIPE_DETAIL.route + "/" + recipe.id)
            }
        }
    }
}