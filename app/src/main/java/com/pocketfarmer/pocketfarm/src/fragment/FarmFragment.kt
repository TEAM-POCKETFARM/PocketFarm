package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentFarmBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailFarmViewModel

class FarmFragment(override val layoutId: Int = R.layout.fragment_farm)
    : BaseFragment<FragmentFarmBinding, DetailFarmViewModel>() {


    override fun getViewModel(): DetailFarmViewModel
            = ViewModelProvider(this).get(DetailFarmViewModel::class.java)


    override fun initView() {

    }


}