package com.domain.feature.story

import com.domain.models.Story
import com.domain.result.Request


interface StoryRepository {
    suspend fun getStory(): Request<Story>
}