package com.example.core.di

import com.example.core.dispatchers.DefaultDispatchersProvider
import com.example.core.dispatchers.DispatchersProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatchersModule {

    @Singleton
    @Binds
    abstract fun bindDispatchers(dispatcher: DefaultDispatchersProvider): DispatchersProvider
}
