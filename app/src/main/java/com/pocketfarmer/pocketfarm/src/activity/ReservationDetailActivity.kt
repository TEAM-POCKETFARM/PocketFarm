package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityReservationDetailBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.ReservationDetailViewModel

class ReservationDetailActivity(override val layoutId: Int = R.layout.activity_reservation_detail)
    : BaseActivity<ActivityReservationDetailBinding, ReservationDetailViewModel>() {
    override fun getViewModel(): ReservationDetailViewModel =
        ViewModelProvider(this).get(ReservationDetailViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {

    }
}