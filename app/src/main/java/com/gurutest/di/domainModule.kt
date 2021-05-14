package com.gurutest.di


import com.domain.feature.story.StoryRepository
import com.domain.feature.story.StoryUseCase
import com.domain.feature.story.StoryUseCaseImpl

import org.koin.dsl.module.applicationContext


val domainModule = applicationContext {

    // ========== STORY

    factory {
        StoryUseCaseImpl(
            get<StoryRepository>()
        ) as StoryUseCase
    }
}