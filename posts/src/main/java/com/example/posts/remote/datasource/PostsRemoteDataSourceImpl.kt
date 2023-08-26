package com.example.posts.remote.datasource

import com.example.core.data.ApiResult
import com.example.core.data.handleApi
import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.data.model.PostEntity
import com.example.posts.remote.api.PostsApi
import com.example.posts.remote.mapper.PostEntityMapper
import com.example.posts.remote.model.PostRemote
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class PostsRemoteDataSourceImpl @Inject constructor(
    private val api: PostsApi,
    private val postEntityMapper: PostEntityMapper
) : PostsRemoteDataSource {

    override suspend fun getPosts(): ApiResult<List<PostEntity>> {
        return when (val result = handleApi { api.getPosts() }) {
            is ApiResult.Success -> ApiResult.Success(postEntityMapper.mapList(result.data!!))
            is ApiResult.Error -> ApiResult.Error(result.error)
        }
    }
}
