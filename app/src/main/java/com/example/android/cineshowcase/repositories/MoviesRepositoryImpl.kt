package com.example.android.cineshowcase.repositories

import com.example.android.cineshowcase.data.mappers.toDomain
import com.example.android.cineshowcase.data.network.ApiService
import com.example.android.cineshowcase.data.network.safeApiCall
import com.example.android.cineshowcase.models.Movie
import com.example.android.cineshowcase.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import com.example.android.cineshowcase.utils.Constants
import com.example.android.cineshowcase.utils.Constants.CATEGORY_NOW_PLAYING_MOVIES
import kotlinx.coroutines.flow.flowOf

class MoviesRepositoryImpl constructor(
    private val apiService: ApiService
) : MoviesRepository {

    override suspend fun fetchMovies(category: String): Flow<NetworkResult<List<Movie>>> {
        val networkResponse = when (category) {
            CATEGORY_NOW_PLAYING_MOVIES -> {
                safeApiCall {
                    apiService.fetchNowPlayingMovies().movies.map { it.toDomain(category = category) }
                }
            }
            else -> {
                safeApiCall {
                    apiService.fetchTrendingMovies().movies
                        .filter { it.mediaType == "movie" }
                        .map { it.toDomain(category = category) }
                }
            }
        }
        return flowOf(networkResponse)
    }
}