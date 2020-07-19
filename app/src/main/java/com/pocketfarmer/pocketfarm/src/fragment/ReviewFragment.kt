package com.pocketfarmer.pocketfarm.src.fragment

import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentReviewBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel

class ReviewFragment(override val layoutId: Int = R.layout.fragment_review)
    : BaseFragment<FragmentReviewBinding, DetailViewModel>() {


    override fun getViewModel(): DetailViewModel = (activity as DetailActivity).viewModelFragment


    override fun initView() {

    }


}