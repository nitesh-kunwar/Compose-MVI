package com.demo.compose.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl("https://imdb8.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var retrofitService : ApiService = retrofitClient.create(ApiService::class.java)

}