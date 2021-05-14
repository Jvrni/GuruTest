package com.core.extensions

import android.app.Activity
import kotlinx.coroutines.*


suspend fun Activity.doWait(delay: Long, block: () -> Unit) =
    withContext(Dispatchers.Main) {
        delay(delay)
        block()
    }
