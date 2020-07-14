package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentCategoryBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.CategoryViewModel

class CategoryFragment(override val layoutId: Int = R.layout.fragment_category)
    : BaseFragment<FragmentCategoryBinding, CategoryViewModel>() {

    override fun getViewModel(): CategoryViewModel
            = ViewModelProvider(this).get(CategoryViewModel::class.java)

    override fun initView() {

    }
}