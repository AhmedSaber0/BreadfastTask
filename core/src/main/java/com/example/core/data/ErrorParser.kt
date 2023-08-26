package com.example.core.data

import retrofit2.HttpException
import java.io.IOException

internal object ErrorParser {

    fun parseError(throwable: Throwable): ApiResult.Error {
        return when (throwable) {
            is HttpException ->
                ApiResult.Error(Errors.ServerError)

            is IOException ->
                ApiResult.Error(Errors.NetworkError(throwable))

            else ->
                ApiResult.Error(Errors.IgnoredError)
        }
    }
}