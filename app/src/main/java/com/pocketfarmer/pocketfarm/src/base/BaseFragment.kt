package com.pocketfarmer.pocketfarm.src.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.transition.ChangeBounds
import com.pocketfarmer.pocketfarm.BR
import com.pocketfarmer.pocketfarm.R

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel> : Fragment(),
    BaseFragmentView<VM> {

    protected lateinit var binding : B
    protected lateinit var viewmodel : VM

    var mProgressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewmodel = getViewModel()
        binding.setVariable(BR.viewModel, viewmodel)
        binding.lifecycleOwner = this

        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 300
        }
        sharedElementReturnTransition = ChangeBounds().apply {
            duration = 300
        }

        initView()

        return binding.root
    }

    open fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    open fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(context)
            mProgressDialog!!.setMessage(getString(R.string.loading))
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setIndeterminate(true)
        }
        if (!isRemoving) {
            mProgressDialog!!.show()
        }
    }

    open fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }
}


interface BaseFragmentView<VM : ViewModel> {

    @get:LayoutRes
    val layoutId: Int

    fun getViewModel() : VM

    fun initView()

}