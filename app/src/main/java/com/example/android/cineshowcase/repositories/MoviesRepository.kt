package com.example.android.cineshowcase.repositories

import com.example.android.cineshowcase.models.Movie
import com.example.android.cineshowcase.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun fetchMovies(category: String): Flow<NetworkResult<List<Movie>>>
}