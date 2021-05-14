package com.data.feature.story.local

import android.content.Context
import com.core.extensions.jsonToClass
import com.data.R
import com.domain.models.Story

class StoryLocalSourceImpl(
    private val context: Context
): StoryLocalSource {
    override fun getStorys(): Story = context.jsonToClass(R.raw.storys)
}