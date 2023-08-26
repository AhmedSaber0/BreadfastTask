package com.example.posts.di

import com.example.posts.data.repository.PostsRepositoryImpl
import com.example.posts.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindPostsRepository(repository: PostsRepositoryImpl): PostsRepository
}
