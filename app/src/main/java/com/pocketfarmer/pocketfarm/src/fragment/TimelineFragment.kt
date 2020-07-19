package com.pocketfarmer.pocketfarm.src.fragment

import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentTimelineBinding
import com.pocketfarmer.pocketfarm.src.activity.ReservationDetailActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.ReservationDetailViewModel

class TimelineFragment(override val layoutId: Int = R.layout.fragment_timeline)
    : BaseFragment<FragmentTimelineBinding, ReservationDetailViewModel>() {

    override fun getViewModel(): ReservationDetailViewModel
            = (activity as ReservationDetailActivity).viewModelFragment

    override fun initView() {

    }
}