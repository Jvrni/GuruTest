package com.story.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.domain.models.Items
import com.story.R
import com.story.adapter.StepAdapter
import com.story.adapter.StoryAdapter
import kotlinx.android.synthetic.main.story.view.*

class Story : FrameLayout {

    private var sleep = 5000L
    private var positionStep = 0
    private var previousPosition = 0

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

    fun setAdapter(list: List<Items>) {
        pagerStory.adapter = StoryAdapter(list, context, onClick = { direction ->
            when(direction.toLowerCase()) {
                LEFT.toLowerCase() -> onClickLeft(list.size)
                RIGHT.toLowerCase() -> onClickRight(list.size)
            }
        })

        rvStepStory.adapter = StepAdapter(
            quantity = list.size,
            sleep = sleep,
            onChangePosition = { updateStep(list) }
        )

        onPageChanged()
    }

    private fun onPageChanged() {
        pagerStory.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            var oldPos: Int = pagerStory.currentItem

            override fun onPageSelected(position: Int) {

                when {
                    position > oldPos || position < oldPos -> {
                        positionStep = position
                        refresh()
                    }
                    else -> return
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                oldPos = pagerStory.currentItem
                previousPosition = position
            }
        })
    }

    private fun updateStep(list: List<Items>) {
        when (positionStep) {
            list.size - ONE_VALUE -> {
                positionStep = FIRST_POSITION
                refresh()
            }
            else -> positionStep = ++positionStep
        }

        pagerStory.currentItem = positionStep
    }

    private fun onClickLeft(maxSize: Int) {
        when (positionStep) {
            FIRST_POSITION -> {
                positionStep = maxSize - ONE_VALUE
            }
            SECOND_POSITION -> {
                --positionStep
                refresh()
            }
            else -> positionStep = --positionStep
        }

        pagerStory.currentItem = positionStep
    }

    private fun onClickRight(maxSize: Int) {
        when (positionStep) {
            maxSize - ONE_VALUE -> {
                positionStep = FIRST_POSITION
                refresh()
            }
            else -> positionStep = ++positionStep
        }

        pagerStory.currentItem = positionStep
    }

    private fun refresh() {
        (rvStepStory.adapter as StepAdapter).cancelJob()
        (rvStepStory.adapter as StepAdapter).updateStep(positionStep)
        (rvStepStory.adapter as StepAdapter).notifyDataSetChanged()
    }

    companion object {
        private const val LEFT = "left"
        private const val RIGHT = "right"

        private const val FIRST_POSITION = 0
        private const val SECOND_POSITION = 1
        private const val ONE_VALUE = 1
    }
}