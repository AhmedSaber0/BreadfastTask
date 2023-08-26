package com.example.posts.presentation.posts.mapper

import com.example.core.mapper.Mapper
import com.example.posts.domain.model.Post
import com.example.posts.presentation.posts.model.PostUiModel
import javax.inject.Inject

class PostUiMapper @Inject constructor() : Mapper<Post, PostUiModel> {

    override fun map(input: Post): PostUiModel {
        return PostUiModel(
            postId = input.postId,
            title = input.title,
            body = input.body
        )
    }
}
