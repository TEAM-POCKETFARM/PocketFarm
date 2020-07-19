package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentTimelineBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.TimelineViewModel

class TimelineFragment(override val layoutId: Int = R.layout.fragment_timeline)
    : BaseFragment<FragmentTimelineBinding, TimelineViewModel>() {

    override fun getViewModel(): TimelineViewModel
            = ViewModelProvider(this).get(TimelineViewModel::class.java)

    override fun initView() {

    }
}