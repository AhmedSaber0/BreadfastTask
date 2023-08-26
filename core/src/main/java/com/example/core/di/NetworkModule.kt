package com.example.core.di

import com.example.core.BuildConfig
import com.example.core.util.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp(baseUrl: BaseUrl): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()

        if (BuildConfig.DEBUG)
            httpClient.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        httpClient.addInterceptor(
            Interceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-RapidAPI-Key", baseUrl.apiKey)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
        )
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideApiClient(okHttpClient: OkHttpClient, baseUrl: BaseUrl): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl.url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
}
