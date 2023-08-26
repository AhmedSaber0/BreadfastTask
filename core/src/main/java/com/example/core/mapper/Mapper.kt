package com.example.core.mapper

interface Mapper<in I, out O> {

    fun map(input: I): O

    fun mapList(input: List<I>): List<O> {
        return input.map { i -> map(i) }
    }
}
