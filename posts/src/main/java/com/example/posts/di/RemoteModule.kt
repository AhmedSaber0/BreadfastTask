package com.example.posts.di

import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.remote.api.PostsApi
import com.example.posts.remote.datasource.PostsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteModule {

    companion object {
        @Provides
        @JvmStatic
        fun providePostsApi(retrofit: Retrofit): PostsApi {
            return retrofit.create(PostsApi::class.java)
        }
    }

    @Binds
    abstract fun bindPostsRemoteDataSource(dataSource: PostsRemoteDataSourceImpl): PostsRemoteDataSource
}
