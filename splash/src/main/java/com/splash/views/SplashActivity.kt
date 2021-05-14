package com.splash.views

import android.os.Bundle
import com.core.base.BaseActivity
import com.core.base.navigateTo
import com.core.extensions.doWait
import com.home.view.HomeActivity
import com.splash.R
import kotlinx.coroutines.launch
import org.koin.android.architecture.ext.viewModel

class SplashActivity : BaseActivity<SplashViewModel>() {

    override val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        navigateToHome()
    }

    private fun navigateToHome() {
        viewModel.launch {
            doWait(1000) {
                viewModel.navigateTo<HomeActivity>( this@SplashActivity)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
        }
    }
}