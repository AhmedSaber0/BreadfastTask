package com.example.core.exception

/**
 * Exception is thrown when an essential parameter is missing in the backend/network response.
 * It's a data class to make asserting that the exception is thrown with a certain message in
 * the testing easier.
 */
data class EssentialParamMissingException(val missingParam: String, val rawObject: Any) :
    RuntimeException("The params: $missingParam are missing in received object: $rawObject")

fun requireEssentialParams(
    rawObject: Any,
    essentialParams: List<EssentialParam>
) {
    val message =
        essentialParams
            .filter { it.value == null }
            .map { it.name }

    if (message.isNotEmpty()) {
        throw EssentialParamMissingException(
            message.toString(), rawObject
        )
    }
}

data class EssentialParam(
    val value: Any?,
    val name: String
)
