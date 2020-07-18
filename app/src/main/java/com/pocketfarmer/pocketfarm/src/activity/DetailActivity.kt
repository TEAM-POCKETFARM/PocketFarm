package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityDetailBinding
import com.pocketfarmer.pocketfarm.src.ReservationBottomSheetDialog
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.fragment.FarmFragment
import com.pocketfarmer.pocketfarm.src.fragment.ProductFragment
import com.pocketfarmer.pocketfarm.src.fragment.QuestionFragment
import com.pocketfarmer.pocketfarm.src.fragment.ReviewFragment
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity(override val layoutId: Int = R.layout.activity_detail)
    : BaseActivity<ActivityDetailBinding, DetailViewModel>(), TabLayout.OnTabSelectedListener {

    private val fragments:ArrayList<Fragment> = arrayListOf(ProductFragment(), FarmFragment(), ReviewFragment(), QuestionFragment())
    lateinit var viewModelFragment: DetailViewModel

    override fun getViewModel(): DetailViewModel {
        val boardIdx = (intent.getSerializableExtra("data") as DataBoard).boardIdx

        return ViewModelProvider(this, DetailViewModelFactory(boardIdx)).get(DetailViewModel::class.java)
    }

    override fun initView(savedInstanceState: Bundle?) {
        viewModelFragment = viewmodel

        setSupportActionBar(detail_toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detail_navigation_bar.addOnTabSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.detail_fragment, fragments[0]).commit()

        detail_reservation_button.setOnClickListener {
            val bottomSheetDialog = ReservationBottomSheetDialog
                .getInstance()
            bottomSheetDialog.show(supportFragmentManager, "bottomSheet")
        }

        viewmodel.setBoardData(intent.getSerializableExtra("data") as DataBoard)
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
        supportFragmentManager.beginTransaction().replace(R.id.detail_fragment, fragments[fragmentShow]).commit()
    }

    class DetailViewModelFactory(private var boardIdx: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = DetailViewModel(boardIdx) as T
    }
}