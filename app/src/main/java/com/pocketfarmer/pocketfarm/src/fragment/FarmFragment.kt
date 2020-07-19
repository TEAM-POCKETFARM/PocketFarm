package com.pocketfarmer.pocketfarm.src.fragment

import android.content.Context
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentFarmBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel

class FarmFragment(override val layoutId: Int = R.layout.fragment_farm)
    : BaseFragment<FragmentFarmBinding, DetailViewModel>() {

    override fun getViewModel(): DetailViewModel = (activity as DetailActivity).viewModelFragment

    override fun initView() {

    }
}