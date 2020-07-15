package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityMainBinding
import com.pocketfarmer.pocketfarm.src.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity (override val layoutId: Int = R.layout.activity_main)
    : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getViewModel(): MainViewModel = ViewModelProvider(this).get(
        MainViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        setupBottomNavigationBar()

        main_toolbar.inflateMenu(R.menu.menu_toolbar)
        setSupportActionBar(main_toolbar)
        supportActionBar?.title = ""

        findNavController(R.id.main_nav_container)
            .addOnDestinationChangedListener { controller, destination, arguments ->
                viewmodel.setTitle(destination.id)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_notify -> {

                return true
            }
            R.id.menu_search -> {

                return true
            }
        }
        return false
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        NavigationUI.setupWithNavController(main_bnv, findNavController(R.id.main_nav_container))
    }
}
