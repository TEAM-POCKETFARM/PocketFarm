package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentProductBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailProductViewModel

class ProductFragment(override val layoutId: Int = R.layout.fragment_product)
    : BaseFragment<FragmentProductBinding, DetailProductViewModel>() {


    override fun getViewModel(): DetailProductViewModel
            = ViewModelProvider(this).get(DetailProductViewModel::class.java)


    override fun initView() {

    }


}