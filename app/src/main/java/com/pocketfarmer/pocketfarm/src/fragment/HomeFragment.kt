package com.pocketfarmer.pocketfarm.src.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.pocketfarmer.pocketfarm.src.base.BaseFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.FragmentHomeBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.activity.DonationActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.HomeViewModel


class HomeFragment(override val layoutId: Int = R.layout.fragment_home):
    BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val contextThemeWrapper = ContextThemeWrapper(activity,
//            R.style.AppTheme
//        );
//        val localInflater = inflater.cloneInContext(contextThemeWrapper);
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getViewModel(): HomeViewModel
        = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun initView() {
        binding.homeDonation.setOnClickListener{
            activity?.startActivity(Intent(activity, DonationActivity::class.java))
        }
        binding.testText.setOnClickListener {
            activity?.startActivity(Intent(activity, DetailActivity::class.java))
        }
    }
}