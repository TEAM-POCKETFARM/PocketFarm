package com.pocketfarmer.pocketfarm.src.fragment

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentHomeBinding
import com.pocketfarmer.pocketfarm.src.activity.DonationActivity
import com.pocketfarmer.pocketfarm.src.model.DataDonation
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel


class HomeFragment(override val layoutId: Int = R.layout.fragment_home):
    BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private lateinit var dataDonation:DataDonation

    override fun getViewModel(): HomeViewModel
        = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun initView() {
        viewmodel.donation.observe(this, Observer {
            dataDonation = it
        })

        binding.homeDonation.setOnClickListener{
            val intent = Intent(activity, DonationActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}