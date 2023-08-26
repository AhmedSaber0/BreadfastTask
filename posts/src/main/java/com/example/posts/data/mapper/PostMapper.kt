package com.example.posts.data.mapper

import com.example.core.mapper.Mapper
import com.example.posts.data.model.PostEntity
import com.example.posts.domain.model.Post
import javax.inject.Inject

class PostMapper @Inject constructor() : Mapper<PostEntity, Post> {

    override fun map(input: PostEntity): Post {

        return Post(
            postId = input.postId,
            title = input.title,
            body = input.body,
        )
    }
}
