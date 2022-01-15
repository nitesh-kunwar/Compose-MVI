package com.demo.compose.data.network

import com.demo.compose.data.models.movie.MovieModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {



    @Headers("x-rapidapi-key: 87419eb20dmsh52ed93a5230a7e1p13fa67jsn8dbec5823699")
    @GET("/auto-complete")
    fun searchMovie(@Query("q") queryString: String): Call<MovieModel>



}