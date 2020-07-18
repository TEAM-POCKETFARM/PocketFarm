package com.pocketfarmer.pocketfarm.src

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.src.adapter.HomeRecyclerAdapter
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel

object BindingAdapter {

    @BindingAdapter(value = ["contents", "viewModel"])
    @JvmStatic
    fun settingAdapter(view: RecyclerView, contents: List<DataBoard>?, viewModel: HomeViewModel) {
        view.adapter?.run {
            if (this is HomeRecyclerAdapter) {
                if (contents != null) {
                    this.contents = contents
                }
                this.notifyDataSetChanged()
            }
        } ?: run {
            if (contents != null) {
                HomeRecyclerAdapter(
                    contents,
                    viewModel
                ).apply { view.adapter = this }
            }
        }
    }

    @BindingAdapter("bind_img_url_circle")
    @JvmStatic
    fun bindImgUrlCircle(view : ImageView, url : String?) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.logo)
            .transition(DrawableTransitionOptions.withCrossFade())
            .circleCrop()
            .into(view)
        view.clipToOutline = true
    }

    @BindingAdapter("bind_img_url")
    @JvmStatic
    fun bindImgUrl(view : ImageView, url : String?) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.logo)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(view)
    }
}