package com.example.posts.data.datasource

import com.example.core.data.ApiResult
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.data.model.PostEntity
import com.example.posts.remote.model.PostRemote
import kotlinx.coroutines.Deferred

interface PostsRemoteDataSource {

    suspend fun getPosts(): ApiResult<List<PostEntity>>

    suspend fun getPostComments(postId: String): ApiResult<List<PostCommentEntity>>
}
