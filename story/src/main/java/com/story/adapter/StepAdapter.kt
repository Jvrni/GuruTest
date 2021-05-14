package com.story.adapter

import android.animation.ObjectAnimator
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.story.R
import kotlinx.android.synthetic.main.item_step.view.*

class StepAdapter(
    private val quantity: Int,
    private val sleep: Long,
    private val onChangePosition: () -> Unit
) : RecyclerView.Adapter<StepAdapter.PageHolder>(), Runnable {

    private lateinit var animation: ObjectAnimator
    private var handler = Handler()
    private var positionStep: Int = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_step, parent, false)
        return PageHolder(view)
    }

    override fun getItemCount(): Int = quantity

    override fun onBindViewHolder(
        holder: PageHolder,
        position: Int
    ) {
        holder.step.progress = 0
        holder.step.max = 1000



        if (holder.adapterPosition == positionStep) {
            handler.postDelayed(this, sleep)
            animation = ObjectAnimator.ofInt(holder.step, "progress", 1000)
                .setDuration(sleep)
            animation.start()
        }
    }

    fun cancelJob() {
        animation.duration = 0
        animation.reverse()
        handler.removeCallbacks(this)
    }

    fun updateStep(position: Int) {
        positionStep = position
    }

    class PageHolder(root: View) : RecyclerView.ViewHolder(root) {
        val step: ProgressBar = root.stepProgress
    }

    override fun run() {
        onChangePosition.invoke()
    }

    override fun onViewDetachedFromWindow(holder: PageHolder) {
        cancelJob()
        super.onViewDetachedFromWindow(holder)
    }
}