package com.example.core.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler

    fun computation(): Scheduler
}
