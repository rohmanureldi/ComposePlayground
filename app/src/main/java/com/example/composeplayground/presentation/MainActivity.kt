package com.example.composeplayground.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.domain.model.RecipeEntity
import com.example.composeplayground.presentation.navigation.RecipeRoute
import com.example.composeplayground.presentation.pages.RecipeListPage
import com.example.composeplayground.presentation.pages.RecipeDetailPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @ExperimentalAnimationApi
    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            val clickedRecipe = remember{
                mutableStateOf(RecipeEntity())
            }

            NavHost(
                navController = navController,
                startDestination = RecipeRoute.RECIPE_LIST.title
            ) {
                composable(RecipeRoute.RECIPE_LIST.title) {
                    RecipeListPage(
                        navController = navController,
                        vm = hiltViewModel(),
                        onRecipeClick = {
                            clickedRecipe.value = it
                        }
                    )
                }
                composable(RecipeRoute.RECIPE_DETAIL.title) {
                    RecipeDetailPage(recipe = clickedRecipe.value)
                }
            }
        }

        viewModel.error.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
