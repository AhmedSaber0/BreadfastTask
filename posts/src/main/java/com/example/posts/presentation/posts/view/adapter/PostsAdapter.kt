package com.example.posts.presentation.posts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.core.adapter.BaseListAdapter
import com.example.posts.databinding.AdapterPostBinding
import com.example.posts.presentation.posts.model.PostUiModel

class PostsAdapter(
    private val onPostItemClicked: (PostUiModel) -> Unit
) : BaseListAdapter<PostUiModel, AdapterPostBinding>(diffCallback = PostsDiffUtil) {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): AdapterPostBinding {
        return AdapterPostBinding.inflate(inflater, parent, false)
    }

    override fun onBindItem(binding: AdapterPostBinding, item: PostUiModel, position: Int) {
        binding.postNameTextview.text = item.title
        binding.postBodyTextview.text = item.body

        binding.root.setOnClickListener { onPostItemClicked.invoke(item) }
    }
}
