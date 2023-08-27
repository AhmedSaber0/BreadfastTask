package com.example.posts.presentation.posts.viewstate

import com.example.core.viewstate.ViewEvent

sealed class PostsViewEvent : ViewEvent {

    data object NoInternet : PostsViewEvent()
}
