package com.example.posts.remote.mapper

import com.example.core.exception.EssentialParam
import com.example.core.exception.requireEssentialParams
import com.example.core.mapper.Mapper
import com.example.posts.data.model.PostEntity
import com.example.posts.remote.model.PostRemote
import javax.inject.Inject

class PostEntityMapper @Inject constructor() : Mapper<PostRemote, PostEntity> {

    override fun map(input: PostRemote): PostEntity {

        assertEssentialParams(input)

        return PostEntity(
            postId = input.id!!,
            title = input.title!!,
            body = input.body!!,
        )
    }

    private fun assertEssentialParams(remote: PostRemote) {
        val essentialParams = listOf(
            EssentialParam(remote.id, "id"),
            EssentialParam(remote.userId, "user_id"),
            EssentialParam(remote.title, "title"),
            EssentialParam(remote.body, "body")
        )

        requireEssentialParams(rawObject = remote, essentialParams = essentialParams)
    }
}
