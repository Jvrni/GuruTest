package com.story.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.domain.models.Story
import com.story.R
import kotlinx.android.synthetic.main.item_story.view.*

class StoryAdapter(
    private val list: List<Story>,
    private val context: Context
): RecyclerView.Adapter<StoryAdapter.PageHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, 
        viewType: Int
    ): PageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return PageHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(
        holder: PageHolder,
        position: Int
    ) {
        val item = list[position]

        Glide.with(context)
            .load(item.image)
            .into(holder.imgStory)

        holder.txtTitle.text = item.title
    }

    class PageHolder(root: View): RecyclerView.ViewHolder(root) {
        val imgStory: ImageView = root.imgStory
        val txtTitle: TextView = root.txtTitleStory
    }
}