package com.example.posts.domain.usecase

import com.example.core.data.ApiResult
import com.example.posts.domain.model.Post
import com.example.posts.domain.repository.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(): ApiResult<List<Post>> {
        return repository.getPosts()
    }
}
