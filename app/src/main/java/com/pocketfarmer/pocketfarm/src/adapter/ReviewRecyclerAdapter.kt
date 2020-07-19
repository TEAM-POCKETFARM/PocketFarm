package com.pocketfarmer.pocketfarm.src.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.RowReviewBinding
import com.pocketfarmer.pocketfarm.src.model.DataReview
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel

class ReviewRecyclerAdapter(var reviews: List<DataReview> = arrayListOf(),
                            var userTexts: List<String> = arrayListOf(), val viewModel: DetailViewModel):
    RecyclerView.Adapter<ReviewRecyclerAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<RowReviewBinding>(itemView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_review, parent, false)

        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int = reviews.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.binding?.item = review

        holder.binding?.reviewUserText?.text = userTexts[position]
    }
}