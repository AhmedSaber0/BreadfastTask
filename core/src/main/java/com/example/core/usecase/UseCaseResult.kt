package com.example.core.usecase

sealed class UseCaseResult<T> {

    data class Success<T>(val data: List<T>) : UseCaseResult<T>()

    data class Error<T>(val throwable: Throwable) : UseCaseResult<T>()
}