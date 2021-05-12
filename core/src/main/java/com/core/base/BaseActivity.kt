package com.core.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

abstract class BaseActivity<ViewModel : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: ViewModel
    private val onDestroyLiveDataBag = mutableListOf<LiveData<*>>()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        with(onDestroyLiveDataBag) {
            forEach { it.removeObservers(this@BaseActivity) }
            clear()
        }
    }

    fun LiveData<*>.removeObserversOnDestroy() {
        onDestroyLiveDataBag.add(this)
    }
}