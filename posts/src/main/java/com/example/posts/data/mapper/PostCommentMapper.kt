package com.example.posts.data.mapper

import com.example.core.mapper.Mapper
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.domain.model.PostComment
import javax.inject.Inject

class PostCommentMapper @Inject constructor() : Mapper<PostCommentEntity, PostComment> {

    override fun map(input: PostCommentEntity): PostComment {

        return PostComment(
            commentId = input.commentId,
            name = input.name,
            email = input.email,
            body = input.body,
        )
    }
}
