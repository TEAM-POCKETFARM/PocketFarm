package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentReviewBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailReviewlViewModel

class ReviewFragment(override val layoutId: Int = R.layout.fragment_review)
    : BaseFragment<FragmentReviewBinding, DetailReviewlViewModel>() {


    override fun getViewModel(): DetailReviewlViewModel
            = ViewModelProvider(this).get(DetailReviewlViewModel::class.java)


    override fun initView() {

    }


}