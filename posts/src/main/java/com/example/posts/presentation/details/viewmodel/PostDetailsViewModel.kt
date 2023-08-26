package com.example.posts.presentation.details.viewmodel

import com.example.core.base.viewmodel.BaseViewModel
import com.example.posts.presentation.details.viewstate.PostDetailsCoordinatorEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewAction
import com.example.posts.presentation.details.viewstate.PostDetailsViewEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewState
import com.example.posts.presentation.posts.model.PostUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor() :
    BaseViewModel<PostDetailsViewState, PostDetailsViewEvent, PostDetailsViewAction, PostDetailsCoordinatorEvent>() {

    override val initViewState: PostDetailsViewState =
        PostDetailsViewState.initState.also { updateViewState(it) }

    override fun postAction(action: PostDetailsViewAction) {
        when (action) {
            is PostDetailsViewAction.BindPostDetailsData -> updateViewState(
                PostDetailsViewState.Success(
                    action.uiModel
                )
            )
        }
    }
}
