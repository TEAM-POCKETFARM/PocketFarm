package com.pocketfarmer.pocketfarm.src.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentHomeBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.activity.DonationActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel


class HomeFragment(override val layoutId: Int = R.layout.fragment_home):
    BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getViewModel(): HomeViewModel
        = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun initView() {
        binding.homeDonation.setOnClickListener{
            activity?.startActivity(Intent(activity, DonationActivity::class.java))
        }
        binding.testText.setOnClickListener {
            activity?.startActivity(Intent(activity, DetailActivity::class.java))
        }
    }
}