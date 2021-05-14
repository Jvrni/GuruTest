package com.domain.feature.story

import com.domain.models.Story

interface StoryUseCase {

    suspend fun getStory(): Story
}