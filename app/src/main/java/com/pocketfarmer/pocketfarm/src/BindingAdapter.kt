package com.pocketfarmer.pocketfarm.src

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.src.adapter.HomeRecyclerAdapter
import com.pocketfarmer.pocketfarm.src.model.Content
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel

@BindingAdapter(value = ["contents", "viewModel"])
fun settingAdapter(view: RecyclerView, contents: List<Content>, viewModel: HomeViewModel) {
    view.adapter?.run {
        if (this is HomeRecyclerAdapter) {
            this.contents = contents
            this.notifyDataSetChanged()
        }
    } ?: run {
        HomeRecyclerAdapter(
            contents,
            viewModel
        ).apply { view.adapter = this }
    }
}