package com.demo.compose.data.models.movie

data class ApiResponse<T>(
    val statusCode:Int,
    val message: String?,
    val data:T?,
    val error:Boolean = false
)
