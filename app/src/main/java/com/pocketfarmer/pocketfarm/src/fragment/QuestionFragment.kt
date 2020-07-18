package com.pocketfarmer.pocketfarm.src.fragment

import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentQuestionBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailQuestionViewModel

class QuestionFragment(override val layoutId: Int = R.layout.fragment_question)
    : BaseFragment<FragmentQuestionBinding, DetailQuestionViewModel>() {


    override fun getViewModel(): DetailQuestionViewModel
            = ViewModelProvider(this).get(DetailQuestionViewModel::class.java)


    override fun initView() {

    }


}