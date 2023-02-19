package com.example.android.cineshowcase.service

import com.example.android.cineshowcase.api.MovieAPI
import com.example.android.cineshowcase.models.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieService {
    //instance of Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun createMovie(movie: Movie){
        val movieAPI: MovieAPI
        movieAPI.createMovie(movie).enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response): Response<Movie>)
            }
            override fun onFailure(call: Call<Movie>, t: Throwable){
        }
    }
}