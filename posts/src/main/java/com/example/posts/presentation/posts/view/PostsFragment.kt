package com.example.posts.presentation.posts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.view.BaseFragment
import com.example.core.extension.showToast
import com.example.posts.R
import com.example.posts.databinding.FragmentPostsBinding
import com.example.posts.presentation.posts.view.adapter.PostsAdapter
import com.example.posts.presentation.posts.viewmodel.PostsViewModel
import com.example.posts.presentation.posts.viewstate.PostsCoordinatorEvent
import com.example.posts.presentation.posts.viewstate.PostsViewAction
import com.example.posts.presentation.posts.viewstate.PostsViewEvent
import com.example.posts.presentation.posts.viewstate.PostsViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : BaseFragment<
        PostsViewState,
        PostsViewEvent,
        PostsViewAction,
        PostsCoordinatorEvent,
        PostsViewModel,
        FragmentPostsBinding>() {

    override val viewModel: PostsViewModel by viewModels()

    override val fragmentTheme: Int = R.style.Theme_Breadfast_posts

    private lateinit var postsAdapter: PostsAdapter

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPostsBinding {
        return FragmentPostsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPostsRecyclerView()
    }

    private fun setupPostsRecyclerView() {
        setupAdapters()
        binding.postsRecyclerView.adapter = postsAdapter
    }

    private fun setupAdapters() {
        postsAdapter = PostsAdapter {
            postAction(PostsViewAction.OpenPostDetails(it.postId, it.title, it.body))
        }
    }

    override fun renderViewState(viewState: PostsViewState) {
        binding.postsProgressBar.isVisible = viewState is PostsViewState.Loading

        when (viewState) {
            is PostsViewState.Loading -> {}
            is PostsViewState.Success -> {
                postsAdapter.submitList(viewState.posts)
            }

            is PostsViewState.Error -> {
                showToast(requireContext(), R.string.server_error)
            }
        }
    }

    override fun renderViewEvent(viewEvent: PostsViewEvent) {
        when (viewEvent) {
            is PostsViewEvent.NoInternet ->
                showToast(requireContext(), R.string.internet_error)
        }
    }

    override fun coordinatorEvent(coordinatorEvent: PostsCoordinatorEvent) {
        when (coordinatorEvent) {
            is PostsCoordinatorEvent.OpenDetails -> {
                val postDetailsAction =
                    PostsFragmentDirections.actionPostsFragmentToPostDetailsFragment(
                        coordinatorEvent.postId,
                        coordinatorEvent.title,
                        coordinatorEvent.body
                    )
                findNavController().navigate(postDetailsAction)
            }
        }
    }
}
