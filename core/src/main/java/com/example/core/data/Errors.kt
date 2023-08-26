package com.example.core.data

sealed class Errors {

    data class NetworkError(val throwable: Throwable) : Errors()

    data class MessageError(val message: String) : Errors()

    object ServerError : Errors()

    object IgnoredError : Errors()
}
