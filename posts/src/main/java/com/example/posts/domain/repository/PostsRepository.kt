package com.example.posts.domain.repository

import com.example.core.data.ApiResult
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.PostComment

interface PostsRepository {

    suspend fun getPosts(): ApiResult<List<Post>>
    suspend fun getPostComments(postId: String): ApiResult<List<PostComment>>
}
