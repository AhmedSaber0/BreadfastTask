package com.example.posts.remote.model

import com.squareup.moshi.Json

data class PostRemote(
    @field:Json(name = "id")
    val id: Long?,
    @field:Json(name = "user_id")
    val userId: Long?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "body")
    val body: String?,
)
