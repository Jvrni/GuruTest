package com.home.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import com.core.base.BaseActivity
import com.core.extensions.hide
import com.core.extensions.observe
import com.core.extensions.show
import com.home.R
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.architecture.ext.viewModel
import com.domain.models.Story

class HomeActivity : BaseActivity<HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        prepareObservers()
        initialize()
        txtEmptyStoryHome.setOnClickListener { initialize() }
    }

    private fun initialize() {
        loadingHome.show()
        viewModel.init()
    }

    private fun prepareObservers() {
        viewModel.storys().observe(this) { story ->
            storyHome.setAdapter(story.items)
            storyHome.show()
            txtStoreHome.show()
            txtEmptyStoryHome.hide()
            loadingHome.hide()
        }

        viewModel.emptyStorys().observe(this) {
            storyHome.hide()
            txtStoreHome.hide()
            loadingHome.hide()
            txtEmptyStoryHome.show()
        }
    }

    fun openPlayStore(view: View) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=vc.com.guruapp")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=vc.com.guruapp")))
        }
    }
}