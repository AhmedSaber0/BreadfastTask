package com.example.core.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BindingViewHolder<out VB : ViewBinding>(val binding: VB) :
    RecyclerView.ViewHolder(binding.root)
