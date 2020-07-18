package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityDonationBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_donation.*

class DonationActivity(override val layoutId: Int = R.layout.activity_donation)
    : BaseActivity<ActivityDonationBinding, HomeViewModel>() {

    override fun getViewModel(): HomeViewModel
            = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        donation_toolbar.setOnMenuItemClickListener {
            finish()
            false
        }
        supportActionBar?.title = ""

        binding.donationTotalText2.bringToFront()
    }
}