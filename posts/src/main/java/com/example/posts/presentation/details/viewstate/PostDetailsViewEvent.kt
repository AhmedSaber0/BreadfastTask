package com.example.posts.presentation.details.viewstate

import com.example.core.viewstate.ViewEvent

sealed class PostDetailsViewEvent : ViewEvent {
    data object NoInternet : PostDetailsViewEvent()
}