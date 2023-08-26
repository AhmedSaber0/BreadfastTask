package com.example.posts.test.factory

import com.example.core_testing.factory.DataFactory.randomLong
import com.example.core_testing.factory.DataFactory.randomString
import com.example.posts.data.model.PostEntity
import com.example.posts.domain.model.Post

object PostFactory {

    fun makePost() = Post(
        postId = randomLong(),
        title = randomString(),
        body = randomString()
    )

    fun makePostEntity() = PostEntity(
        postId = randomLong(),
        title = randomString(),
        body = randomString(),
    )

}
