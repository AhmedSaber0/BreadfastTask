package com.example.core.data

sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T?) : ApiResult<T>()

    data class Error(val error: Errors) : ApiResult<Nothing>()
}


inline fun <T : Any> ApiResult<T>.onSuccess(action: (T?) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success)
        action.invoke(this.data)

    return this
}

inline fun <T : Any> ApiResult<T>.onError(action: (Errors) -> Unit): ApiResult<T> {
    if (this is ApiResult.Error)
        action.invoke(error)

    return this
}