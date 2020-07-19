package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityReservationDetailBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.fragment.CategoryFragment
import com.pocketfarmer.pocketfarm.src.fragment.TimelineFragment
import com.pocketfarmer.pocketfarm.src.viewmodel.ReservationDetailViewModel
import kotlinx.android.synthetic.main.activity_reservation_detail.*

class ReservationDetailActivity(override val layoutId: Int = R.layout.activity_reservation_detail)
    : BaseActivity<ActivityReservationDetailBinding, ReservationDetailViewModel>(),
    TabLayout.OnTabSelectedListener {
    private val fragments:ArrayList<Fragment> = arrayListOf(TimelineFragment(), CategoryFragment())


    override fun getViewModel(): ReservationDetailViewModel =
        ViewModelProvider(this).get(ReservationDetailViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
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
}