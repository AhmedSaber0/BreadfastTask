package com.example.posts.test.factory

import com.example.core_testing.factory.DataFactory.randomLong
import com.example.core_testing.factory.DataFactory.randomString
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.domain.model.PostComment

object PostCommentFactory {

    fun makePostComment() = PostComment(
        commentId = randomLong(),
        name = randomString(),
        email = randomString(),
        body = randomString()
    )

    fun makePostCommentEntity() = PostCommentEntity(
        commentId = randomLong(),
        name = randomString(),
        email = randomString(),
        body = randomString(),
    )

}
