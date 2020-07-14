package com.pocketfarmer.pocketfarm.src.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivitySignInBinding
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.SignInViewModel

class SignInActivity(override val layoutId: Int = R.layout.activity_sign_in) : BaseActivity<ActivitySignInBinding, SignInViewModel>() {

    override fun getViewModel(): SignInViewModel
            = ViewModelProvider(this).get(SignInViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}