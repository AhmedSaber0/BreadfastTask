package com.example.core.usecase

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

abstract class ObservableUseCase<Results : Any, in Params>(
    private val threadExecutor: Scheduler,
    private val postExecutionThread: Scheduler
) {

    /**
     * Builds an [Observable] which will be used when executing the current [ObservableUseCase].
     */
    abstract fun buildUseCaseObservable(params: Params? = null): Observable<Results>

    /**
     * Executes the current use case.
     *
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    open fun execute(params: Params? = null): Observable<Results> {
        return buildUseCaseObservable(params)
            .subscribeOn(threadExecutor)
            .observeOn(postExecutionThread)
    }
}