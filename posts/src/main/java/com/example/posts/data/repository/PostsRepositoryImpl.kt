package com.example.posts.data.repository

import com.example.core.data.ApiResult
import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.data.mapper.PostMapper
import com.example.posts.domain.model.Post
import com.example.posts.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsRemoteDataSource: PostsRemoteDataSource,
    private val postMapper: PostMapper
) : PostsRepository {

    override suspend fun getPosts(): ApiResult<List<Post>> {
        return when (val result = postsRemoteDataSource.getPosts()) {
            is ApiResult.Success -> ApiResult.Success(postMapper.mapList(result.data!!))
            is ApiResult.Error -> ApiResult.Error(result.error)
        }
    }
}
