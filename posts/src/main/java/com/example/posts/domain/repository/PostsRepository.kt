package com.example.posts.domain.repository

import com.example.core.data.ApiResult
import com.example.posts.domain.model.Post

interface PostsRepository {

    suspend fun getPosts(): ApiResult<List<Post>>
}
