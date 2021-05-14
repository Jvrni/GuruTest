package com.gurutest

import android.app.Application
import com.gurutest.di.dataModule
import com.gurutest.di.domainModule
import com.gurutest.di.viewModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // koin 1.0.0 will allow the application to load it's modules on activity creation
        // best approach would be to update it as soon as this new version gets stable
        // also, separate the modules by feature
        startKoin(
            this,
            listOf(
                dataModule,
                domainModule,
                viewModule
            )
        )
    }
}