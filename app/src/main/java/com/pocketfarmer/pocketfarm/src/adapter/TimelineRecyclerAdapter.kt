package com.pocketfarmer.pocketfarm.src.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.RowTimelineBinding
import com.pocketfarmer.pocketfarm.src.model.DataTimeline
import com.pocketfarmer.pocketfarm.src.viewmodel.TimelineViewModel

class TimelineRecyclerAdapter(var timeline: List<DataTimeline> = arrayListOf(), val viewModel: TimelineViewModel):
    RecyclerView.Adapter<TimelineRecyclerAdapter.TimelineViewHolder>() {

    class TimelineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<RowTimelineBinding>(itemView)
        val line2 = itemView.findViewById<ImageView>(R.id.line2)
        val line3 = itemView.findViewById<ImageView>(R.id.line3)
        val line4 = itemView.findViewById<ImageView>(R.id.line4)
        val line5 = itemView.findViewById<ImageView>(R.id.line5)
        val circle = itemView.findViewById<View>(R.id.circle)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimelineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_timeline, parent, false)

        return TimelineViewHolder(view)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
//        val content = contents[position]
//        holder.binding?.item = content

        if(position == 4){
            holder.line2.visibility = View.GONE
            holder.line3?.visibility = View.GONE
            holder.line4?.visibility = View.GONE
            holder.line5?.visibility = View.GONE
            holder.circle?.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#ffc61c"))
        }
    }
}