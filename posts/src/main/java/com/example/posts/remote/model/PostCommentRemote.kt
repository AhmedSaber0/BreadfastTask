package com.example.posts.remote.model

import com.squareup.moshi.Json

data class PostCommentRemote(
    @field:Json(name = "id")
    val id: Long?,
    @field:Json(name = "post_id")
    val postId: Long?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "email")
    val email: String?,
    @field:Json(name = "body")
    val body: String?,
)
