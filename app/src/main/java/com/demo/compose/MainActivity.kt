package com.demo.compose

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.demo.compose.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val imageview: ImageView = findViewById(R.id.image)
//        val url ="https://ia.media-imdb.com/images/M/MV5BMTczNjM0NDY0Ml5BMl5BcG5nXkFtZTgwMTk1MzQ2OTE@._V1._SX40_CR0,0,40,59_.png"
        val url ="https://static01.nyt.com/images/2020/12/14/well/14google-photo/14google-photo-facebookJumbo.jpg"
//        Glide.with(this).load(url).into(imageview)
    }
}

