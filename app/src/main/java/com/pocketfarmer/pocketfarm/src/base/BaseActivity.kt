package com.pocketfarmer.pocketfarm.src.base

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.navigation.ActivityNavigator
import com.pocketfarmer.pocketfarm.BR
import com.pocketfarmer.pocketfarm.NetworkEvent
import com.pocketfarmer.pocketfarm.R

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity(),
    BaseActivityView<VM> {

    protected lateinit var binding : B
    protected lateinit var viewmodel : VM

    var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewmodel = getViewModel()
        binding.setVariable(BR.viewModel, viewmodel)
        binding.lifecycleOwner = this

        initView(savedInstanceState)
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

    open fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    open fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this, android.R.style.Theme_DeviceDefault_Dialog)
        }
        mProgressDialog!!.apply {
            setMessage(getString(R.string.loading))
            setCancelable(false)
            setIndeterminate(true)
        }
        if (!isFinishing) mProgressDialog!!.show()
    }

    open fun hideProgressDialog() {
        mProgressDialog?.apply { if (isShowing) dismiss() }
    }

    override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }

    override fun handleNetworkEvent(state: NetworkEvent.NetworkState?) {
        when(state) {
            NetworkEvent.NetworkState.LOADING -> showProgressDialog()
            NetworkEvent.NetworkState.SUCCESS -> {
                hideProgressDialog()
            }
            NetworkEvent.NetworkState.FAILURE -> {
                hideProgressDialog()
            }
            NetworkEvent.NetworkState.ERROR -> {
                hideProgressDialog()
                showToast(getString(R.string.network_error))
            }
            else -> {
                hideProgressDialog()
            }
        }
    }


    /* 화면 터치시 키보드 레이아웃 감추기 코드 */
    private var firstPointX = 0f
    private var firstPointY = 0f
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_UP) {
            val distX = Math.abs(ev.x - firstPointX)
            val distY = Math.abs(ev.y - firstPointY)
            if (distX < 8 || distY < 8) {
                val view = currentFocus
                if (view is EditText) {
                    val outRect = Rect()
                    view.getGlobalVisibleRect(outRect)
                    if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                        val inputMethodManager =
                            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
                    }
                }
            }
        } else if (ev.action == MotionEvent.ACTION_DOWN) {
            firstPointX = ev.x
            firstPointY = ev.y
        }
        return super.dispatchTouchEvent(ev)
    }
}

interface BaseActivityView<VM : ViewModel> {

    @get:LayoutRes
    val layoutId: Int

    fun getViewModel() : VM

    fun initView(savedInstanceState: Bundle?)

    fun handleNetworkEvent(state : NetworkEvent.NetworkState?)
}