package com.example.android.cineshowcase.api

import com.example.android.cineshowcase.models.Movie
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {

    @POST("movie")
    fun createMovie(@Body movie: Movie) : Call<Movie>

    @GET("movie")
    fun getMovies(): Call<List<Movie>>

    @GET("movie/{id}")
    fun getMovie(@Path("id") id: Int): Call<Movie>

    @PUT("movie/{id}")
    fun updateMovie(@Path("id") id: Int, @Body movie: Movie): Call<Movie>

    @DELETE("movie/{id}")
    fun deleteMovie(@Path("id") id: Int): Call<Void>
}