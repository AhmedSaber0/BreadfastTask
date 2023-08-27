package com.example.posts.presentation.details.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.core.adapter.BaseListAdapter
import com.example.posts.databinding.AdapterCommentBinding
import com.example.posts.presentation.posts.model.PostCommentUiModel

class PostCommentsAdapter :
    BaseListAdapter<PostCommentUiModel, AdapterCommentBinding>(diffCallback = PostCommentDiffUtil) {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): AdapterCommentBinding {
        return AdapterCommentBinding.inflate(inflater, parent, false)
    }

    override fun onBindItem(
        binding: AdapterCommentBinding,
        item: PostCommentUiModel,
        position: Int
    ) {
        binding.nameTextview.text = item.name
        binding.bodyTextview.text = item.body
    }
}
