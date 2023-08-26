package com.example.posts.remote.api

import com.example.posts.remote.model.PostRemote
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<PostRemote>
}
