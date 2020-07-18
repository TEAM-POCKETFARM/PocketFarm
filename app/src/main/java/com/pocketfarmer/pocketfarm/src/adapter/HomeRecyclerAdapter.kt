package com.pocketfarmer.pocketfarm.src.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.RowHomeContentsBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel

class HomeRecyclerAdapter(var contents: List<DataBoard> = arrayListOf(), val viewModel: HomeViewModel): RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<RowHomeContentsBinding>(itemView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_home_contents, parent, false)
        val holder = HomeViewHolder(view)
        
        view.setOnClickListener {
            viewModel.navigateTo(DetailActivity::class.java, contents[holder.adapterPosition])
        }
        
        return holder
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val content = contents[position]
        holder.binding?.item = content
    }
}