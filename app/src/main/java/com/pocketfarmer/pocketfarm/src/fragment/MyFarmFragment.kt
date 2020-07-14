package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentMyFarmBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.MyFarmViewModel

class MyFarmFragment(override val layoutId: Int = R.layout.fragment_my_farm)
    : BaseFragment<FragmentMyFarmBinding, MyFarmViewModel>() {


    override fun getViewModel(): MyFarmViewModel
            = ViewModelProvider(this).get(MyFarmViewModel::class.java)


    override fun initView() {

    }


}