package com.example.posts.presentation.details.viewstate

import com.example.core.viewstate.ViewState
import com.example.posts.presentation.posts.model.PostCommentUiModel
import com.example.posts.presentation.posts.model.PostUiModel
import com.example.posts.presentation.posts.viewstate.PostsViewState

sealed class PostDetailsViewState : ViewState {

    data object Loading : PostDetailsViewState()

    data class Success(
        val postComments: List<PostCommentUiModel>,
        val postDetails: PostUiModel,
        val empty: Boolean,
    ) : PostDetailsViewState()

    data object Error : PostDetailsViewState()
}