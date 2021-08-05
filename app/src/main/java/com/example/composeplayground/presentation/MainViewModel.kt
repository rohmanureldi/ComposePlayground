package com.example.composeplayground.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.domain.ApiUsecase
import com.example.composeplayground.domain.model.RecipeEntity
import com.example.composeplayground.domain.model.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ApiUsecase
): ViewModel() {

//    val recipeList = mutableStateOf<List<RecipeEntity>>(emptyList())
    val recipeList = mutableStateOf<UIState<List<RecipeEntity>>>(UIState.Default())

    val query = mutableStateOf("")

    val error = MutableLiveData<String>("")

    val testingVisibility = mutableStateOf(false)

    init {
        query.value = "Chicken"
        searchRecipe()
    }

    fun searchRecipe() {
        recipeList.value = UIState.Loading()
        viewModelScope.launch {
            try {
                val recipe = useCase.searchRecipe(1, query.value)
                recipeList.value = UIState.Sucess(recipe)
            } catch (e: Exception) {
                error.value = e.message
                recipeList.value = UIState.Error(e)
            }
        }
    }

    fun onQueryChanged(text: String) {
        query.value = text
    }

    fun changeVisibiliity() {
        testingVisibility.value = !testingVisibility.value
    }

}