package com.example.posts.domain.usecase

import com.example.core.data.ApiResult
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.PostComment
import com.example.posts.domain.repository.PostsRepository
import javax.inject.Inject

class GetPostCommentsUseCase @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(postId : String): ApiResult<List<PostComment>> {
        return repository.getPostComments(postId)
    }
}
