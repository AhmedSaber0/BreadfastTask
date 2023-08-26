package com.example.core.di

import com.example.core.scheduler.AppSchedulerProvider
import com.example.core.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SchedulersModule {

    @Singleton
    @Binds
    abstract fun bindSchedulers(schedulers: AppSchedulerProvider): SchedulerProvider
}
