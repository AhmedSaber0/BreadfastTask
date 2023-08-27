package com.example.posts.presentation.details.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.data.ApiResult
import com.example.core.dispatchers.DispatchersProvider
import com.example.core.util.NetworkChecker
import com.example.posts.domain.model.PostComment
import com.example.posts.domain.usecase.GetPostCommentsUseCase
import com.example.posts.presentation.details.viewstate.PostDetailsCoordinatorEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewAction
import com.example.posts.presentation.details.viewstate.PostDetailsViewEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewState
import com.example.posts.presentation.posts.mapper.PostCommentUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val commentsUseCase: GetPostCommentsUseCase,
    private val postCommentUiMapper: PostCommentUiMapper,
    private val networkChecker: NetworkChecker,
    private val dispatchers: DispatchersProvider,
) : BaseViewModel<PostDetailsViewState, PostDetailsViewEvent, PostDetailsViewAction, PostDetailsCoordinatorEvent>() {

    override val initViewState: PostDetailsViewState =
        PostDetailsViewState.Loading.also { updateViewState(it) }

    override fun postAction(action: PostDetailsViewAction) {
        when (action) {
            is PostDetailsViewAction.BindPostDetailsData -> {
                getPostComments(action.uiModel.postId.toString())
                updateViewState(
                    PostDetailsViewState.Success(
                        postComments = emptyList(),
                        postDetails = action.uiModel,
                        empty = true
                    )
                )
            }
        }
    }

    private fun getPostComments(postId: String) {
        safeRequest {
            viewModelScope.launch(dispatchers.io()) {
                when (val result = commentsUseCase.invoke(postId)) {
                    is ApiResult.Success -> onGetPostsSuccess(result)

                    is ApiResult.Error -> onGetPostsError()

                }
            }
        }
    }

    private fun onGetPostsSuccess(result: ApiResult.Success<List<PostComment>>) {
        val success = currentViewState() as? PostDetailsViewState.Success
        if (success != null) {
            updateViewState(
                success.copy(
                    postComments = result.data?.map { post -> postCommentUiMapper.map(post) }!!,
                    empty = result.data?.isEmpty()!!
                )
            )
        }
    }

    private fun onGetPostsError() {
        updateViewState(PostDetailsViewState.Error)
    }

    private fun safeRequest(request: () -> Unit) {
        if (networkChecker.isConnectedToInternet()) {
            request.invoke()
        } else {
            updateViewEvent(PostDetailsViewEvent.NoInternet)
        }
    }
}
