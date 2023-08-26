package com.example.posts.presentation.posts.viewstate

import com.example.core.navigation.CoordinatorEvent

sealed class PostsCoordinatorEvent : CoordinatorEvent {

    data class OpenDetails(val postId: Long, val title: String, val body: String) : PostsCoordinatorEvent()
}
