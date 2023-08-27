package com.example.posts.remote.datasource

import com.example.core.data.ApiResult
import com.example.core.data.handleApi
import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.data.model.PostEntity
import com.example.posts.remote.api.PostsApi
import com.example.posts.remote.mapper.PostCommentEntityMapper
import com.example.posts.remote.mapper.PostEntityMapper
import com.example.posts.remote.model.PostRemote
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class PostsRemoteDataSourceImpl @Inject constructor(
    private val api: PostsApi,
    private val postEntityMapper: PostEntityMapper,
    private val postCommentEntityMapper: PostCommentEntityMapper
) : PostsRemoteDataSource {

    override suspend fun getPosts(): ApiResult<List<PostEntity>> {
        return when (val result = handleApi { api.getPosts() }) {
            is ApiResult.Success -> ApiResult.Success(postEntityMapper.mapList(result.data!!))
            is ApiResult.Error -> ApiResult.Error(result.error)
        }
    }

    override suspend fun getPostComments(postId: String): ApiResult<List<PostCommentEntity>> {
        return when (val result = handleApi { api.getPostComments(postId = postId) }) {
            is ApiResult.Success -> ApiResult.Success(postCommentEntityMapper.mapList(result.data!!))
            is ApiResult.Error -> ApiResult.Error(result.error)
        }
    }
}
