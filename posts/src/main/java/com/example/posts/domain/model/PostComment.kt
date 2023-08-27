package com.example.posts.domain.model

data class PostComment(
    val commentId: Long,
    val name: String,
    val email: String,
    val body: String
)
