package com.gurutest.di

import com.core.base.navigateTo
import com.domain.feature.story.StoryUseCase
import com.home.view.HomeActivity
import com.home.view.HomeViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val viewModule = applicationContext {

    // SPLASH

//    factory { SplashActivity() }
//
//    bean {
//        SplashViewModel(get<StoryUseCase>())
//    }
//
//    viewModel {
//        SplashViewModel(get<StoryUseCase>())
//    }

    // HOME

    bean {
        HomeViewModel(get<StoryUseCase>())
    }

    factory(HomeActivity::class.java.canonicalName + "Screen") {
        HomeViewModel(get<StoryUseCase>()).navigateTo<HomeActivity>(get())
    }

    viewModel {
        HomeViewModel(get<StoryUseCase>())
    }
}