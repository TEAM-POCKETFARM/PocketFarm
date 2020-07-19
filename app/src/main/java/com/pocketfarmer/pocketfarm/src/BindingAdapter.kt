package com.pocketfarmer.pocketfarm.src

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.src.adapter.HomeRecyclerAdapter
import com.pocketfarmer.pocketfarm.src.adapter.ReviewRecyclerAdapter
import com.pocketfarmer.pocketfarm.src.adapter.TimelineRecyclerAdapter
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import com.pocketfarmer.pocketfarm.src.model.DataReview
import com.pocketfarmer.pocketfarm.src.model.DataTimeline
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel
import com.pocketfarmer.pocketfarm.src.viewmodel.TimelineViewModel
import kotlin.math.roundToInt

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

    @BindingAdapter(value = ["reviews", "userTexts", "viewModel"])
    @JvmStatic
    fun settingReviewAdapter(view: RecyclerView, reviews: List<DataReview>?, userTexts: List<String>?, viewModel: DetailViewModel) {
        view.adapter?.run {
            if (this is ReviewRecyclerAdapter) {
                if (reviews != null && userTexts != null) {
                    this.reviews = reviews
                    this.userTexts = userTexts
                }
                this.notifyDataSetChanged()
            }
        } ?: run {
            if (reviews != null && userTexts != null) {
                ReviewRecyclerAdapter(
                    reviews,
                    userTexts,
                    viewModel
                ).apply { view.adapter = this }
            }
        }
    }

    @BindingAdapter(value = ["timeline", "viewModel"])
    @JvmStatic
    fun settingReviewAdapter(view: RecyclerView, timeline: List<DataTimeline>?, viewModel: TimelineViewModel) {
        view.adapter?.run {
            if (this is TimelineRecyclerAdapter) {
                if (timeline != null) {
                    this.timeline = timeline
                }
                this.notifyDataSetChanged()
            }
        } ?: run {
            if (timeline != null) {
                TimelineRecyclerAdapter(
                    timeline,
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

    @BindingAdapter("score")
    @JvmStatic
    fun starScore(view:LinearLayout, score:Double?){
        if (score != null) {
            var newScore = 0
            var flag = false
            if(score - score.roundToInt() >= 0.0){
                newScore = score.roundToInt()
            }else {
                newScore = score.roundToInt()
                flag = true
            }

            for(i in 0 until newScore){
                if(i == newScore - 1 && flag){
                    (view[i] as ImageView).setImageResource(R.drawable.star_half)
                    break
                }
                (view[i] as ImageView).setImageResource(R.drawable.star_on)
            }
        }
    }
}