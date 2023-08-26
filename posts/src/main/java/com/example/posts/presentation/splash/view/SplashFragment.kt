package com.example.posts.presentation.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.view.BaseFragment
import com.example.core.viewstate.EmptyViewAction
import com.example.core.viewstate.EmptyViewEvent
import com.example.core.viewstate.EmptyViewState
import com.example.posts.R
import com.example.posts.databinding.FragmentSplashBinding
import com.example.posts.presentation.splash.viewmodel.SplashViewModel
import com.example.posts.presentation.splash.viewstate.SplashCoordinatorEvent
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import kotlin.concurrent.schedule

@AndroidEntryPoint
class SplashFragment : BaseFragment<
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewAction,
        SplashCoordinatorEvent,
        SplashViewModel,
        FragmentSplashBinding>() {

    override val viewModel: SplashViewModel by viewModels()

    override val fragmentTheme: Int = R.style.Theme_Breadfast_posts

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openPostsAfterDelay()
    }

    private fun openPostsAfterDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            val postsAction = SplashFragmentDirections.actionSplashFragmentToPostsFragment()
            findNavController().navigate(postsAction)
        }, 2000)
    }

    override fun coordinatorEvent(coordinatorEvent: SplashCoordinatorEvent) {
    }

    override fun renderViewEvent(viewEvent: EmptyViewEvent) {
    }

    override fun renderViewState(viewState: EmptyViewState) {
    }

}