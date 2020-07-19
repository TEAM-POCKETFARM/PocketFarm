package com.pocketfarmer.pocketfarm.src.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityReservationDetailBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.fragment.CategoryFragment
import com.pocketfarmer.pocketfarm.src.fragment.MyFarmFragment
import com.pocketfarmer.pocketfarm.src.fragment.TimelineFragment
import com.pocketfarmer.pocketfarm.src.viewmodel.MyFarmViewModel
import com.pocketfarmer.pocketfarm.src.viewmodel.ReservationDetailViewModel
import kotlinx.android.synthetic.main.activity_reservation_detail.*

class ReservationDetailActivity(override val layoutId: Int = R.layout.activity_reservation_detail)
    : BaseActivity<ActivityReservationDetailBinding, ReservationDetailViewModel>(),
    TabLayout.OnTabSelectedListener {

    private val fragments:ArrayList<Fragment> = arrayListOf(TimelineFragment(), CategoryFragment())
    lateinit var viewModelFragment: ReservationDetailViewModel
    var position:Int = 0

    override fun getViewModel(): ReservationDetailViewModel {
        val boardIdx = intent.getIntExtra("boardIdx", -1)

        return ViewModelProvider(this,
            ReservationDetailViewModelFactory(boardIdx)).get(ReservationDetailViewModel::class.java)
    }

    override fun initView(savedInstanceState: Bundle?) {
        viewModelFragment = viewmodel
        val sharedPreferences = getSharedPreferences("pocketFarm", Context.MODE_PRIVATE)

        binding.viewModelReservation = ViewModelProvider(this,
            MyFarmFragment.MyFarmViewModelFactory(sharedPreferences.getInt("userIdx", -1))
        ).get(MyFarmViewModel::class.java)
        binding.position = this

        position = intent.getIntExtra("position", 0)

        setSupportActionBar(detail_reservation_toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detail_reservation_navigation_bar.addOnTabSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.detail_reservation_fragment, fragments[0]).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.position?.let { fragmentChange(it) }
    }

    private fun fragmentChange(fragmentShow:Int){
        supportFragmentManager.beginTransaction().replace(R.id.detail_reservation_fragment, fragments[fragmentShow]).commit()
    }

    class ReservationDetailViewModelFactory(private var boardIdx: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = ReservationDetailViewModel(boardIdx) as T
    }
}