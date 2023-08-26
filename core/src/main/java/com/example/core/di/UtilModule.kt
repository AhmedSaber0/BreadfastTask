package com.example.core.di

import com.example.core.util.NetworkChecker
import com.example.core.util.NetworkCheckerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilModule {

    @Binds
    abstract fun bindNetworkChecker(networkChecker: NetworkCheckerImpl): NetworkChecker
}
