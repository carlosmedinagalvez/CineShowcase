package com.example.android.cineshowcase.data.network

import com.example.android.cineshowcase.data.MovieResultsDto
import com.example.android.cineshowcase.utils.Constants.STARTING_PAGE_INDEX
import io.ktor.client.*
import io.ktor.client.request.*

class ApiService constructor(private val httpClient: HttpClient) {
    suspend fun fetchNowPlayingMovies(page: Int = STARTING_PAGE_INDEX): MovieResultsDto {
        return httpClient.get<MovieResultsDto>(urlString = "movie/now_playing") {
            parameter("page", page)
        }
    }
    suspend fun fetchTrendingMovies(
        mediaType: String = "movie",
        timeWindow: String = "week",
        page: Int = STARTING_PAGE_INDEX
    ): MovieResultsDto {
        return httpClient.get<MovieResultsDto>(urlString = "trending/$mediaType/$timeWindow") {
            parameter("page", page)
        }
    }
}