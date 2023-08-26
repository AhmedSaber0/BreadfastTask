package com.example.posts.presentation.details.viewstate

import com.example.core.viewstate.ViewState
import com.example.posts.presentation.posts.model.PostUiModel

sealed class PostDetailsViewState : ViewState {

    object initState : PostDetailsViewState()

    data class Success(val postDetails: PostUiModel) : PostDetailsViewState()
}