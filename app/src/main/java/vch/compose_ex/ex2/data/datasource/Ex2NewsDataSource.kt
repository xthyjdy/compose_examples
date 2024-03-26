package vch.compose_ex.ex2.data.datasource

import retrofit2.Response
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse

interface Ex2NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<Ex2ApiNewsResponse>
}