package com.story.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.domain.models.Items
import com.story.R
import kotlinx.android.synthetic.main.item_story.view.*


class StoryAdapter(
    private val list: List<Items>,
    private val context: Context,
    private val onClick: (direction: String) -> Unit
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
        holder.clickLeft.setOnClickListener { onClick(LEFT) }
        holder.clickRight.setOnClickListener { onClick(RIGHT) }
        holder.imgStory.setOnClickListener { openBrowser(item.link) }
        holder.txtTitle.setOnClickListener { openBrowser(item.link) }
    }

    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(context, browserIntent, null)
    }

    class PageHolder(root: View): RecyclerView.ViewHolder(root) {
        val imgStory: ImageView = root.imgStory
        val txtTitle: TextView = root.txtTitleStory
        val clickLeft: View = root.clickLeft
        val clickRight: View = root.clickRight
    }

    companion object {
        private const val LEFT = "left"
        private const val RIGHT = "right"
    }
}