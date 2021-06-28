package com.demo.compose.data.network

import com.demo.compose.data.models.movie.MovieModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {


    @Headers("x-rapidapi-key: de2f155dc4msh92ff4135a3d3c4fp1d3fefjsncedf95ba5786")
    @GET("/auto-complete")
    fun searchMovie(@Query("q") queryString: String): Call<MovieModel>



}