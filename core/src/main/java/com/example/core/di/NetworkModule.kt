package com.example.core.di

import com.example.core.util.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp(baseUrl: BaseUrl): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()

        httpClient.addInterceptor(
            Interceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
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
