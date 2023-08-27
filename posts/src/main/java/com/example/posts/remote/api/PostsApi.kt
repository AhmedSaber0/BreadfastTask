package com.example.posts.remote.api

import com.example.posts.remote.model.PostCommentRemote
import com.example.posts.remote.model.PostRemote
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<PostRemote>

    @GET("posts/{postId}/comments")
    suspend fun getPostComments(
        @Path("postId") postId: String
    ): List<PostCommentRemote>
}
