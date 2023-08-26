package com.example.posts.presentation

import android.view.LayoutInflater
import com.example.core.base.view.BaseActivity
import com.example.core.navigation.StartDestination
import com.example.posts.R
import com.example.posts.databinding.ActivityPostsHostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsHostActivity : BaseActivity<ActivityPostsHostBinding>() {

    override val activityTheme: Int = R.style.Theme_Breadfast_posts

    override val graph: Int = R.navigation.posts_nav_graph

    override val navHostId: Int = R.id.navHost

    override fun startDestination(): StartDestination = StartDestination(R.id.splashFragment, null)

    override fun onCreateBinding(inflater: LayoutInflater): ActivityPostsHostBinding {
        return ActivityPostsHostBinding.inflate(inflater)
    }
}
