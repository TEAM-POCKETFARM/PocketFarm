package com.pocketfarmer.pocketfarm.src.activity

import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ActivityMainBinding
import com.pocketfarmer.pocketfarm.setupWithNavController
import com.pocketfarmer.pocketfarm.src.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity (override val layoutId: Int = R.layout.activity_main)
    : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private var currentNavController: LiveData<NavController>? = null

    override fun getViewModel(): MainViewModel = ViewModelProvider(this).get(
        MainViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        setupBottomNavigationBar()
        main_toolbar.inflateMenu(R.menu.menu_toolbar)
        setSupportActionBar(main_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_category,
            R.navigation.nav_my_farm
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.mainBnv.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_nav_container,
            intent = intent
        )

        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean = currentNavController?.value?.navigateUp() ?: false
}
