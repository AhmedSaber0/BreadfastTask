package com.example.posts.presentation.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.base.view.BaseFragment
import com.example.core.extension.loadImage
import com.example.posts.R
import com.example.posts.databinding.FragmentPostDetailsBinding
import com.example.posts.presentation.details.viewmodel.PostDetailsViewModel
import com.example.posts.presentation.details.viewstate.PostDetailsCoordinatorEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewAction
import com.example.posts.presentation.details.viewstate.PostDetailsViewEvent
import com.example.posts.presentation.details.viewstate.PostDetailsViewState
import com.example.posts.presentation.posts.model.PostUiModel
import com.example.posts.presentation.posts.viewstate.PostsViewAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : BaseFragment<
        PostDetailsViewState,
        PostDetailsViewEvent,
        PostDetailsViewAction,
        PostDetailsCoordinatorEvent,
        PostDetailsViewModel,
        FragmentPostDetailsBinding>() {

    override val viewModel: PostDetailsViewModel by viewModels()

    override val fragmentTheme: Int = R.style.Theme_Breadfast_posts

    private val args: PostDetailsFragmentArgs by navArgs()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPostDetailsBinding {
        return FragmentPostDetailsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postAction(
            PostDetailsViewAction.BindPostDetailsData(
                PostUiModel(
                    args.postId,
                    args.title,
                    args.body
                )
            )
        )
    }

    override fun renderViewState(viewState: PostDetailsViewState) {
        when (viewState) {
            is PostDetailsViewState.initState -> {
            }

            is PostDetailsViewState.Success -> {
                binding.postNameTextview.text = viewState.postDetails.title
                binding.postBodyTextview.text = viewState.postDetails.body
            }
        }

    }

    override fun renderViewEvent(viewEvent: PostDetailsViewEvent) {
    }

    override fun coordinatorEvent(coordinatorEvent: PostDetailsCoordinatorEvent) {

    }
}
