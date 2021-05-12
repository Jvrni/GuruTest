package com.story.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.story.R
import kotlinx.android.synthetic.main.item_step.view.*
import kotlinx.coroutines.*

class StepAdapter(
    private val quantity: Int,
    private val sleep: Long,
    private val positionStep: Int,
    private val onChangePosition: () -> Unit
) : RecyclerView.Adapter<StepAdapter.PageHolder>() {

    private var job: Job? = null

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

        if (position == positionStep) {
            ObjectAnimator.ofInt(holder.step, "progress", 1000)
                .setDuration(sleep)
                .start()

            job = GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    delay(sleep)
                    onChangePosition.invoke()
                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }

    class PageHolder(root: View) : RecyclerView.ViewHolder(root) {
        val step: ProgressBar = root.stepProgress
    }
}