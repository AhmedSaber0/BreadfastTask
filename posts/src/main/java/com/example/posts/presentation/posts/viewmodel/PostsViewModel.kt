package com.example.posts.presentation.posts.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.data.ApiResult
import com.example.core.dispatchers.DispatchersProvider
import com.example.core.util.NetworkChecker
import com.example.posts.domain.model.Post
import com.example.posts.domain.usecase.GetPostsUseCase
import com.example.posts.presentation.posts.mapper.PostUiMapper
import com.example.posts.presentation.posts.viewstate.PostsCoordinatorEvent
import com.example.posts.presentation.posts.viewstate.PostsViewAction
import com.example.posts.presentation.posts.viewstate.PostsViewEvent
import com.example.posts.presentation.posts.viewstate.PostsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val postUiMapper: PostUiMapper,
    private val networkChecker: NetworkChecker,
    private val dispatchers: DispatchersProvider,
) : BaseViewModel<PostsViewState, PostsViewEvent, PostsViewAction, PostsCoordinatorEvent>() {

    override val initViewState: PostsViewState = PostsViewState.Loading.also { updateViewState(it) }

    override fun postAction(action: PostsViewAction) {
        when (action) {
            is PostsViewAction.OpenPostDetails -> {
                sendCoordinatorEvent(PostsCoordinatorEvent.OpenDetails(action.postId, action.title, action.body))
            }
        }
    }

    init {
        safeRequest {
            viewModelScope.launch(dispatchers.io()) {
                when (val result = getPostsUseCase.invoke()) {
                    is ApiResult.Success -> onGetPostsSuccess(result)

                    is ApiResult.Error -> onGetPostsError()

                }
            }
        }
    }

    private fun onGetPostsSuccess(result: ApiResult.Success<List<Post>>) {
        updateViewState(
            PostsViewState.Success(
                posts = result.data?.map { post -> postUiMapper.map(post) }!!,
                empty = result.data?.isEmpty()!!
            )
        )
    }

    private fun onGetPostsError() {
        updateViewState(PostsViewState.Error)
    }

    private fun safeRequest(request: () -> Unit) {
        if (networkChecker.isConnectedToInternet()) {
            request.invoke()
        } else {
            updateViewEvent(PostsViewEvent.NoInternet)
        }
    }
}
