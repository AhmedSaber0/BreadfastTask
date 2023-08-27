package com.example.posts.presentation.posts.mapper

import com.example.core.mapper.Mapper
import com.example.posts.domain.model.PostComment
import com.example.posts.presentation.posts.model.PostCommentUiModel
import javax.inject.Inject

class PostCommentUiMapper @Inject constructor() : Mapper<PostComment, PostCommentUiModel> {

    override fun map(input: PostComment): PostCommentUiModel {
        return PostCommentUiModel(
            name = input.name,
            email = input.email,
            body = input.body
        )
    }
}
