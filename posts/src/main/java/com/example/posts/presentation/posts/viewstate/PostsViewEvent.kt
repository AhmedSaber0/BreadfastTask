package com.example.posts.presentation.posts.viewstate

import com.example.core.viewstate.ViewEvent

sealed class PostsViewEvent : ViewEvent {

    object NextPageError : PostsViewEvent()

    object NoInternet : PostsViewEvent()
}
