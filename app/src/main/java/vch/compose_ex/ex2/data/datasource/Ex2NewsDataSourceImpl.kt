package vch.compose_ex.ex2.data.datasource

import retrofit2.Response
import vch.compose_ex.ex2.data.api.Ex2ApiService
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse
import javax.inject.Inject

class Ex2NewsDataSourceImpl @Inject constructor(
    private val apiService: Ex2ApiService
) : Ex2NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<Ex2ApiNewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}