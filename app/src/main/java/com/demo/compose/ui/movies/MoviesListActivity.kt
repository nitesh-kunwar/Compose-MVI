package com.demo.compose.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.demo.compose.R
import com.demo.compose.data.models.movie.D
import com.google.accompanist.glide.LocalRequestManager
import com.google.accompanist.glide.rememberGlidePainter

class MoviesListActivity : AppCompatActivity() {

    private val viewModel by viewModels<MoviesListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.uiState.collectAsState()
            showContent(state)
        }
    }


    @Composable
    private fun showContent(state: State<MoviesListViewState>) {
        Log.e("State ", state.value.toString())
        Scaffold(topBar = { AppBar() },
            content = {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.white))) {
                    SearchView(state)
                    MoviesListComposable(state.value.movies)
                }
            }
        )
    }

    @Composable
    fun AppBar() {
        TopAppBar(
            title = { Text(text = "Movies") },
        )
    }


    @Composable
    fun SearchView(state: State<MoviesListViewState>) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(shape = RoundedCornerShape(5.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .background(color = colorResource(id = R.color.white)),
                value = state.value.searchString,
                onValueChange = { viewModel.userIntentChannel.offer(UserIntents.OnTextChanged(it)) },
                label = { Text(text = "Search Movie") }
            )
            Image(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 30.dp)
                    .size(50.dp),
                painter = painterResource(id = R.drawable.ic_search_black),
                contentDescription = null
            )
        }
    }

    @Composable
    private fun MoviesListComposable(movies: List<D>?) {
        if (movies == null) {
            Image(painter = painterResource(id = R.drawable.no_data), contentDescription =null )
        } else {
            LazyColumn(Modifier.fillMaxWidth()) {
                items(movies) { item -> MovieRowComposable(item) }
            }
        }


    }

    @Composable
    fun MovieRowComposable(item: D) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(modifier = Modifier
                .background(
                    color = colorResource(id = R.color.light_grey)
                )
                .padding(5.dp)
                ) {
                Image(modifier = Modifier.size(80.dp),
                    painter =  rememberGlidePainter(request = item.i?.imageUrl, previewPlaceholder = R.drawable.ic_search),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                    verticalArrangement = Arrangement.Center) {
                    Text(text = item.l, fontFamily = FontFamily.SansSerif)
                    Text(modifier = Modifier.padding(top=10.dp), text = item.s!!, fontFamily = FontFamily.Cursive)
                }
            }
        }
    }

}