package com.pocketfarmer.pocketfarm.src.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.RowTimelineBinding
import com.pocketfarmer.pocketfarm.src.model.DataReservationDetail
import com.pocketfarmer.pocketfarm.src.viewmodel.ReservationDetailViewModel

class TimelineRecyclerAdapter(var timeline: List<DataReservationDetail> = arrayListOf(), val viewModel: ReservationDetailViewModel):
    RecyclerView.Adapter<TimelineRecyclerAdapter.TimelineViewHolder>() {

    class TimelineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<RowTimelineBinding>(itemView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimelineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_timeline, parent, false)

        return TimelineViewHolder(view)
    }

    override fun getItemCount(): Int = timeline.size

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        val content = timeline[position]
        holder.binding?.item = content

        if(position == timeline.lastIndex){
            holder.binding?.line2?.visibility = View.GONE
            holder.binding?.line3?.visibility = View.GONE
            holder.binding?.line4?.visibility = View.GONE
            holder.binding?.line5?.visibility = View.GONE
            holder.binding?.circle?.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#ffc61c"))
        }
    }
}