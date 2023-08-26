package com.example.posts.presentation.posts.viewstate

import com.example.core.viewstate.ViewState
import com.example.posts.presentation.posts.model.PostUiModel

sealed class PostsViewState : ViewState {

    data object Loading : PostsViewState()

    data class Success(
        val posts: List<PostUiModel>,
        val empty: Boolean,
    ) : PostsViewState()

    data object Error : PostsViewState()
}
