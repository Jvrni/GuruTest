package com.data.feature.story.local

import com.domain.models.Story

interface StoryLocalSource {
    fun getStorys(): Story
}