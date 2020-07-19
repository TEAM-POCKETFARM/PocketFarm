package com.pocketfarmer.pocketfarm.src.fragment

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentMyFarmBinding
import com.pocketfarmer.pocketfarm.src.activity.ReservationDetailActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.MyFarmViewModel

class MyFarmFragment(override val layoutId: Int = R.layout.fragment_my_farm)
    : BaseFragment<FragmentMyFarmBinding, MyFarmViewModel>() {

    override fun getViewModel(): MyFarmViewModel{
        val sharedPreferences = activity?.getSharedPreferences("pocketFarm", Context.MODE_PRIVATE)
        val userIdx = sharedPreferences?.getInt("userIdx", -1)

        return ViewModelProvider(this, MyFarmViewModelFactory(userIdx)).get(MyFarmViewModel::class.java)
    }



    override fun initView() {
        binding.myFarmReservationCard1.setOnClickListener {
            val intent = Intent(activity, ReservationDetailActivity::class.java)
            startActivity(intent)
        }
    }

    class MyFarmViewModelFactory(private var userIdx: Int?) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = userIdx?.let {
            MyFarmViewModel(
                it
            )
        } as T
    }
}