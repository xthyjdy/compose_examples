package vch.compose_ex.ex2.ui_ex2.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import vch.compose_ex.Helper.l
import vch.compose_ex.ex2.data.datasource.Ex2NewsDataSource
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse
import vch.utilities.ResourceState
import javax.inject.Inject

class Ex2Repository @Inject constructor(
    private val dataSource: Ex2NewsDataSource
) {
//    suspend fun getNewsHeadline(country: String): Response<Ex2ApiNewsResponse> {
//        return dataSource.getNewsHeadline(country)
//    }

    suspend fun getNewsHeadline(country: String) : Flow<ResourceState<Ex2ApiNewsResponse>> {
        return flow {
            emit( ResourceState.Loading() )
            val response = dataSource.getNewsHeadline(country)

            if (response.isSuccessful && response.body() != null) {
                emit( ResourceState.Success(response.body()!!) )
            } else {
                l(response.body().toString())
                emit( ResourceState.Error("_____response.errorBody()") )
//                ResourceState.Error(response.errorBody())
            }
        }.catch { e ->
            l(e?.message.toString())
            emit( ResourceState.Error(e?.localizedMessage ?: "___e?.localizedMessage") )
        }
    }
}