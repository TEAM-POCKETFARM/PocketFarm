package com.pocketfarmer.pocketfarm.src.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.RowHomeContentsBinding
import com.pocketfarmer.pocketfarm.src.model.Content
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel

class HomeRecyclerAdapter(var contents: List<Content> = arrayListOf(), val viewModel: HomeViewModel): RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<RowHomeContentsBinding>(itemView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_home_contents, parent, false)

        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val content = contents[position]
        holder.binding?.item = content
    }
}