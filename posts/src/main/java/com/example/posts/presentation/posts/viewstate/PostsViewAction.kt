package com.example.posts.presentation.posts.viewstate

import com.example.core.viewstate.ViewAction

sealed class PostsViewAction : ViewAction {

    data class OpenPostDetails(val postId: Long, val title: String, val body: String) :
        PostsViewAction()
}
