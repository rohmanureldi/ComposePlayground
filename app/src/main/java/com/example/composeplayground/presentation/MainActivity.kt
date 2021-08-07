package com.example.composeplayground.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.presentation.router.airlinesRouter.AirlinesRouter
import com.example.composeplayground.presentation.router.MenuRouter
import com.example.composeplayground.presentation.router.RouterModule
import com.example.composeplayground.presentation.pages.MenuPage
import com.example.composeplayground.presentation.pages.airlinesApp.home.AirlinesHome
import com.example.composeplayground.presentation.pages.recipeApp.home.RecipeHomePage
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

            NavHost(
                navController = navController,
                startDestination = MenuRouter.HOME_MENU.route
            ) {
                composable(MenuRouter.HOME_MENU.route) {
                    MenuPage(
                        navController = navController,
                        menuList = RouterModule.getModulesHome()
                    )
                }

                composable(AirlinesRouter.HOME.route) {
                    AirlinesHome()
                }

                composable(
                    "RecipeHome"
                ) {
                    RecipeHomePage(recipeVm = hiltViewModel())
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
