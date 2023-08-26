package com.example.core.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onEndReached(block: () -> Unit) {
    addOnScrollListener(
        object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
// In dx we only care about the negative values because our horizontal is RTL.
                if (dy > 0 || dx < 0) {
                    val visibleItemCount = recyclerView.layoutManager!!.childCount
                    val totalCount = recyclerView.layoutManager!!.itemCount
                    val firstVisibleItems =
                        (recyclerView.layoutManager!! as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (visibleItemCount + firstVisibleItems == totalCount) {
                        block()
                    }
                }
            }
        }
    )
}
