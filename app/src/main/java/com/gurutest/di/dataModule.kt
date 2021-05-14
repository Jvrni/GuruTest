package com.gurutest.di

import android.content.Context
import com.data.feature.story.StoryRepositoryImpl
import com.data.feature.story.local.StoryLocalSource
import com.data.feature.story.local.StoryLocalSourceImpl
import com.domain.feature.story.StoryRepository
import org.koin.dsl.module.applicationContext


val dataModule = applicationContext {


    //     ========= STORY

    bean {
        StoryRepositoryImpl(
            get<StoryLocalSource>()
        ) as StoryRepository
    }

    bean {
        StoryLocalSourceImpl(
            get<Context>()
        ) as StoryLocalSource
    }
}