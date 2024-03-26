package vch.compose_ex.ex2.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse

interface Ex2ApiService {
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=e218a394b12e45b5aa737a24c3465f1f
    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "e218a394b12e45b5aa737a24c3465f1f"
    ): Response<Ex2ApiNewsResponse>
}