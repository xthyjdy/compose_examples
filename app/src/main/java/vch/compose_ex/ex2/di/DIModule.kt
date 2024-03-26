package vch.compose_ex.ex2.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import vch.compose_ex.ex2.data.Ex2AppConstants.BASE_URL
import vch.compose_ex.ex2.data.api.Ex2ApiService
import vch.compose_ex.ex2.data.datasource.Ex2NewsDataSource
import vch.compose_ex.ex2.data.datasource.Ex2NewsDataSourceImpl
import vch.compose_ex.ex2.ui_ex2.repository.Ex2Repository
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Ex2AppModule {
    @Provides
    @Singleton
    fun providesEx2Repository(dataSource: Ex2NewsDataSource) : Ex2Repository {
        return Ex2Repository(dataSource)
    }

    @Provides
    @Singleton
    fun providesEx2NewsDataSource(apiService: Ex2ApiService) : Ex2NewsDataSource {
        return Ex2NewsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesEx2Retrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }
        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build();
    }

    @Provides
    @Singleton
    fun providesEx2ApiService(retrofit: Retrofit): Ex2ApiService {
        return retrofit.create(Ex2ApiService::class.java)
    }
}