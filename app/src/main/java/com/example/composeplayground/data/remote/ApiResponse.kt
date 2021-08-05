package com.example.composeplayground.data.remote

import com.google.gson.JsonObject

data class ApiResponse<T>(
    val count: Int?,
    val next: String?,
    val prev: String?,
    val results: T?
)