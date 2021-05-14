package com.home.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.core.base.BaseViewModel
import com.domain.feature.story.StoryUseCase
import com.domain.models.Story
import kotlinx.coroutines.launch

class HomeViewModel(
    private val storyUseCase: StoryUseCase
) : BaseViewModel() {

    private val _storys = MutableLiveData<Story>()
    fun storys(): LiveData<Story> = _storys

    private val _emptyStorys = MutableLiveData<Unit>()
    fun emptyStorys(): LiveData<Unit> = _emptyStorys

    fun init() {
        launch {
            val result = storyUseCase.getStory()

            when {
                result.items.isEmpty() -> _emptyStorys.value = Unit
                else -> _storys.value = result
            }
        }
    }
}
