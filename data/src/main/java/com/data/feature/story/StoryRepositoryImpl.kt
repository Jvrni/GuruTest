package com.data.feature.story

import com.data.feature.story.local.StoryLocalSource
import com.domain.feature.story.StoryRepository
import com.domain.models.Story
import com.domain.result.Request

class StoryRepositoryImpl(
    private val storyLocalSource: StoryLocalSource
): StoryRepository {
    override suspend fun getStory(): Request<Story> = try {
        Request.success(storyLocalSource.getStorys())
    } catch (e: Exception) {
        Request.error(e)
    }
}