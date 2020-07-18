package com.pocketfarmer.pocketfarm.src.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityPayBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.PayViewModel
import kotlinx.android.synthetic.main.activity_pay.*

class PayActivity(override val layoutId: Int = R.layout.activity_pay) : BaseActivity<ActivityPayBinding, PayViewModel>() {
    override fun getViewModel(): PayViewModel = ViewModelProvider(this).get(PayViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        pay_toolbar.setOnMenuItemClickListener {
            finish()
            false
        }
        supportActionBar?.title = ""

        pay_reword_text2.bringToFront()
        pay_reword_text2.text = viewmodel.setReword(intent.getIntExtra("price", 0), 0.005)

        pay_bm_text2.bringToFront()
        pay_bm_text2.text = viewmodel.setReword(intent.getIntExtra("price", 0), 0.001)

        pay_my_farm_check_button.setOnClickListener {
            
        }
        pay_donation_check_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}