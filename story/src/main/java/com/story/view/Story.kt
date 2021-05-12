package com.story.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.domain.models.Story
import com.story.R
import com.story.adapter.StepAdapter
import com.story.adapter.StoryAdapter
import kotlinx.android.synthetic.main.story.view.*
import kotlinx.coroutines.*

class Story : FrameLayout {

    private var sleep = 5000L
    private var positionStep = 0

    constructor(context: Context) : super(context) {
        setupView()
    }

    constructor(
        context: Context,
        attrs: AttributeSet
    ) : super(context, attrs) {
        setupView(attrs)
    }

    private fun setupView(attrs: AttributeSet? = null) {
        View.inflate(context, R.layout.story, this)
        attrs?.let { attributeSet ->
            context.obtainStyledAttributes(
                attributeSet,
                R.styleable.Story, 0, 0
            ).run {
                recycle()
            }
        }
    }

    fun setAdapter(list: List<Story>) {
        pagerStory.adapter = StoryAdapter(list, context)

        rvStepStory.adapter = StepAdapter(
            quantity = list.size,
            sleep = sleep,
            positionStep = positionStep,
            onChangePosition = { updateStep(list) }
        )

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                delay(500)
                onPageChanged(list)
            }
        }
    }

    private fun onPageChanged(list: List<Story>) {
        pagerStory.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                positionStep = position - 1

                (rvStepStory.adapter as StepAdapter).cancelJob()
                updateStep(list)
            }
        })
    }

    private fun updateStep(list: List<Story>) {
        if (list.size - 1 > positionStep)
            positionStep++
        else
            positionStep = 0

        pagerStory.currentItem = positionStep

        rvStepStory.adapter = StepAdapter(
            quantity = list.size,
            sleep = sleep,
            positionStep = positionStep,
            onChangePosition = { updateStep(list) }
        )
    }
}