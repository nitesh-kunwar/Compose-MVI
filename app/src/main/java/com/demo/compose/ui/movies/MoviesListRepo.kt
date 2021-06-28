package com.demo.compose.ui.movies

import android.util.Log
import com.demo.compose.data.models.movie.ApiResponse
import com.demo.compose.data.models.movie.MovieModel
import com.demo.compose.data.network.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse

class MoviesListRepo {


    suspend fun  searchMovie(query:String): Flow<ApiResponse<MovieModel>> {
        return flow {
            val response = RetrofitClient.retrofitService.searchMovie(queryString = query).awaitResponse().body()
            response?.let {
                Log.e("API RESPONSE ", it.toString())
            }

            emit(ApiResponse<MovieModel>(200, "Success", response, false))
        }.catch {
            e->
            e.message?.let { Log.e("API ERROR " , it) }
        }
    }

}