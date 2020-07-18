package com.pocketfarmer.pocketfarm.src.fragment

import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentProductBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel

class ProductFragment(override val layoutId: Int = R.layout.fragment_product)
    : BaseFragment<FragmentProductBinding, DetailViewModel>() {


    override fun getViewModel(): DetailViewModel = (activity as DetailActivity).viewModelFragment


    override fun initView() {

    }


}