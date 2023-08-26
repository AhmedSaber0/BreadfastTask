package com.example.posts.presentation.details.viewstate

import com.example.core.viewstate.ViewAction
import com.example.posts.presentation.posts.model.PostUiModel

sealed class PostDetailsViewAction : ViewAction{

    data class BindPostDetailsData(val uiModel: PostUiModel) : PostDetailsViewAction()
}