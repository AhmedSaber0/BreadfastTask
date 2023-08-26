package com.example.core.exception

class EssentialParamMissingBuilder(private val rawObject: Any) {
    private val missingParams = StringBuilder()

    fun addMissingField(field: String): EssentialParamMissingBuilder {
        missingParams.append("$field ")
        return this
    }

    fun throwExceptionIfParamsAreMissing() {
        if (missingParams.isNotEmpty()) {
            throw EssentialParamMissingException(missingParams.toString().trim(), rawObject)
        }
    }
}
