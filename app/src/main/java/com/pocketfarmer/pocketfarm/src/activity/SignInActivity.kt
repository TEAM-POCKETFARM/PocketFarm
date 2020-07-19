package com.pocketfarmer.pocketfarm.src.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivitySignInBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.SignInViewModel

class SignInActivity(override val layoutId: Int = R.layout.activity_sign_in) : BaseActivity<ActivitySignInBinding, SignInViewModel>() {

    override fun getViewModel(): SignInViewModel
            = ViewModelProvider(this).get(SignInViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences("pocketFarm", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        viewmodel.responseData.observe(this, Observer {
            if(it.statusCode == 200){
                editor.putInt("userIdx", it.dataUser!!.userIdx).commit()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else if(it.statusCode == 400) showToast("로그인 실패")
        })
    }

}