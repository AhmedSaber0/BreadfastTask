package com.example.core.model

import android.content.res.Resources
import androidx.annotation.ArrayRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

/**
 * Inspired from https://hannesdorfmann.com/abstraction-text-resource/.
 */
sealed class TextResource {
    companion object {
        // Just needed for static method factory so that we can keep concrete implementations file private.
        fun fromText(text: String): TextResource = SimpleTextResource(text)

        fun fromStringId(@StringRes id: Int, vararg formatArgs: Any?): TextResource =
            IdTextResource(id, if (formatArgs.isEmpty()) null else formatArgs.map { it })

        fun fromPlural(@PluralsRes id: Int, pluralValue: Int): TextResource =
            PluralTextResource(id, pluralValue)

        fun fromStringArrayId(@ArrayRes id: Int, index: Int): TextResource =
            ArrayTextResource(id, index)
    }
}

private data class SimpleTextResource(
    val text: String
) : TextResource()

private data class IdTextResource(
    @StringRes val id: Int,
    val formatArgs: List<Any?>? = null
) : TextResource()

private data class PluralTextResource(
    @PluralsRes val pluralId: Int,
    val quantity: Int
) : TextResource()

private data class ArrayTextResource(
    @ArrayRes val arrayId: Int,
    val index: Int
) : TextResource()

fun TextResource.asString(resources: Resources): String = when (this) {
    is SimpleTextResource -> text

    is IdTextResource ->
        if (formatArgs != null) {
            resources.getString(
                id,
                *formatArgs.map {
                    if (it is TextResource) it.asString(resources)
                    else it
                }.toTypedArray()
            )
        } else {
            resources.getString(id)
        }

    is PluralTextResource -> resources.getQuantityString(pluralId, quantity)

    is ArrayTextResource -> resources.getStringArray(arrayId)[index] ?: ""
}
