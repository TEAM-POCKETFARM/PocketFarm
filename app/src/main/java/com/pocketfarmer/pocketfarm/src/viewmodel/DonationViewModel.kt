package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pocketfarmer.pocketfarm.src.model.DataDonation

class DonationViewModel(application: Application) : AndroidViewModel(application){
    lateinit var donation: DataDonation
    lateinit var donationRate: String

    fun setDonationData(donation: DataDonation) {
        this.donation = donation
        donationRate = donation.archiveRate.toString()
    }
}