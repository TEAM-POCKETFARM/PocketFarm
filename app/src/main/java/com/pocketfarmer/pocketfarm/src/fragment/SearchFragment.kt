package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentSearchBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.SearchViewModel

class SearchFragment(override val layoutId: Int = R.layout.fragment_search)
    : BaseFragment<FragmentSearchBinding, SearchViewModel>() {


    override fun getViewModel(): SearchViewModel
            = ViewModelProvider(this).get(SearchViewModel::class.java)


    override fun initView() {

    }


}