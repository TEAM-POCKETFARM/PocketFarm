package com.pocketfarmer.pocketfarm.src.activity

import android.content.Context
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
        val sharedPreferences = getSharedPreferences("pocketFarm", Context.MODE_PRIVATE)

        pay_toolbar.setOnMenuItemClickListener {
            finish()
            false
        }
        supportActionBar?.title = ""

        val boardIdx = intent.getIntExtra("boardIdx", -1)
        val userIdx = sharedPreferences.getInt("userIdx", -1)
        val amount = intent.getIntExtra("amount", 0)
        val price = intent.getIntExtra("price", 0)
        val ea = intent.getIntExtra("ea", 1)

        pay_reword_text2.bringToFront()
        pay_reword_text2.text = viewmodel.setReword(price * ea, 0.05)

        pay_bm_text2.bringToFront()
        pay_bm_text2.text = viewmodel.setReword(price * ea, 0.01)

        viewmodel.reservation(boardIdx, userIdx, amount, price.toString(), ea,
            pay_reword_text2.text.toString(), pay_bm_text2.text.toString())

        pay_my_farm_check_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                action = "pocketFarm.fromPay"
            })
            finish()
        }
        pay_donation_check_button.setOnClickListener {
            startActivity(Intent(this, DonationActivity::class.java))
            finish()
        }
    }

}