package com.example.posts.remote.mapper

import com.example.core.exception.EssentialParam
import com.example.core.exception.requireEssentialParams
import com.example.core.mapper.Mapper
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.remote.model.PostCommentRemote
import javax.inject.Inject

class PostCommentEntityMapper @Inject constructor() : Mapper<PostCommentRemote, PostCommentEntity> {

    override fun map(input: PostCommentRemote): PostCommentEntity {

        assertEssentialParams(input)

        return PostCommentEntity(
            commentId = input.id!!,
            name = input.name!!,
            email = input.email!!,
            body = input.body!!,
        )
    }

    private fun assertEssentialParams(remote: PostCommentRemote) {
        val essentialParams = listOf(
            EssentialParam(remote.id, "id"),
            EssentialParam(remote.postId, "post_id"),
            EssentialParam(remote.name, "name"),
            EssentialParam(remote.email, "email"),
            EssentialParam(remote.body, "body")
        )

        requireEssentialParams(rawObject = remote, essentialParams = essentialParams)
    }
}
