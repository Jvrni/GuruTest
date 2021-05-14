package com.core.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.standalone.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent, CoroutineScope {
    private val job = Job()

    override val coroutineContext = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}


inline fun <reified T : BaseActivity<*>> BaseViewModel.navigateTo(context: Context) =
    context.startActivity(Intent(context, T::class.java))

fun BaseViewModel.navigateTo(context: Context, intent: Intent) =
    context.startActivity(intent)

fun BaseViewModel.navigateToForResult(activity: Activity, intent: Intent, code: Int) =
    activity.startActivityForResult(intent, code)