package com.example.core.data

import retrofit2.Response

suspend fun <T : Any> handleApi(call: suspend () -> T?): ApiResult<T> {
    return try {
        val callResponse = call.invoke()

        if (callResponse is Response<*>)
        //Handel calls with empty response
            return if (callResponse.isSuccessful)
                ApiResult.Success(callResponse)
            else ApiResult.Error(Errors.ServerError)
        else
            ApiResult.Success(callResponse)
    } catch (throwable: Throwable) {
        ErrorParser.parseError(throwable)
    }
}