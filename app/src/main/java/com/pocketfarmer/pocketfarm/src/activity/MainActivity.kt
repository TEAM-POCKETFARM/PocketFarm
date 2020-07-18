package com.pocketfarmer.pocketfarm.src.activity

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityMainBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity (override val layoutId: Int = R.layout.activity_main)
    : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getViewModel(): MainViewModel
            = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        setupBottomNavigationBar()

        supportActionBar?.title = ""

        main_bnv.itemIconTintList = null

        findNavController(R.id.main_nav_container)
            .addOnDestinationChangedListener { controller, destination, arguments ->
                viewmodel.setTitle(destination.id)
                if(destination.id == R.id.fg_home) binding.mainTitle.typeface =
                    resources.getFont(R.font.montserrat_medium)
            }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        NavigationUI.setupWithNavController(main_bnv, findNavController(R.id.main_nav_container))
    }
}
