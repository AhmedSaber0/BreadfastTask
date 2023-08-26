package com.example.posts.presentation.posts.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.posts.presentation.posts.model.PostUiModel

object PostsDiffUtil : DiffUtil.ItemCallback<PostUiModel>() {

    override fun areItemsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem == newItem
    }
}
