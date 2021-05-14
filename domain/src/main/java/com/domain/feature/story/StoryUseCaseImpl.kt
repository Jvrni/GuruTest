package com.domain.feature.story

import com.domain.models.Story
import com.domain.result.or


class StoryUseCaseImpl(
    private val storyRepository: StoryRepository
) : StoryUseCase {
    override suspend fun getStory(): Story =
        storyRepository.getStory() or { Story() }
}