package com.example.posts.presentation.details.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.posts.presentation.posts.model.PostCommentUiModel

object PostCommentDiffUtil : DiffUtil.ItemCallback<PostCommentUiModel>() {

    override fun areItemsTheSame(
        oldItem: PostCommentUiModel,
        newItem: PostCommentUiModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: PostCommentUiModel,
        newItem: PostCommentUiModel
    ): Boolean {
        return oldItem == newItem
    }
}
