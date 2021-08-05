package com.example.composeplayground.domain.model

sealed class UIState<T> {
    class Loading<T> : UIState<T>()
    class Default<T> : UIState<T>()
    data class Sucess<T>(val data: T): UIState<T>()
    data class Error<T>(val error: Exception): UIState<T>()
}
