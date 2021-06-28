package com.demo.compose.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.demo.compose.R
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

class DetailActivity : ComponentActivity() {
    private val viewModel by viewModels<DetailViewModel>()
    private lateinit var imageview: ImageView
    private lateinit var title: TextView
    private lateinit var s: TextView
    private lateinit var vt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findViews()
        viewModel.userIntentChannel.trySend(UserIntents.ParseBundle(intent.extras))
        observeState()
    }

    private fun findViews() {
        imageview = findViewById(R.id.image)
        title = findViewById(R.id.title)
        s = findViewById(R.id.s)
        vt = findViewById(R.id.vt)

    }

    private fun observeState() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                setData(viewModel.uiState)
            }
        }
    }

    private fun setData(uiState: StateFlow<DetailViewState>) {
        val data = uiState.value.movieData
        data?.let {
            Glide.with(this).load(it.i?.imageUrl).into(imageview)
            title.text = it.l
            s.text = it.s ?: ""
            vt.text = it.vt.toString()
        }
    }
}

