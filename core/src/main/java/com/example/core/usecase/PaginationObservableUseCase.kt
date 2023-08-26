package com.example.core.usecase

import androidx.annotation.VisibleForTesting
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.subjects.BehaviorSubject

abstract class PaginationObservableUseCase<T, in Params>(
    private val threadExecutor: Scheduler,
    private val postExecutionThread: Scheduler
) : ObservableUseCase<UseCaseResult<T>, Params>(threadExecutor, postExecutionThread) {

    private lateinit var pagination: BehaviorSubject<Int>

    private lateinit var resultObservable: BehaviorSubject<UseCaseResult<T>>

    protected val results = mutableSetOf<T>()

    var page = 1
        protected set

    var hasMore = false
        protected set

    abstract val pageSize: Int

    protected var resetPage = true

    override fun buildUseCaseObservable(params: Params?): Observable<UseCaseResult<T>> {
        pagination = BehaviorSubject.create()
        resultObservable = BehaviorSubject.create()

        if (resetPage) {
            page = 1
            results.clear()
            pagination.onNext(page)
        }

        return pagination.concatMap {
            loadPage(params, it, pageSize)
                .map<UseCaseResult<T>> { result -> UseCaseResult.Success(result) }
                .onErrorReturn { throwable -> UseCaseResult.Error(throwable) }
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
        }.flatMap {
            if (it is UseCaseResult.Success) {
                hasMore = it.data.size == pageSize

                results.addAll(it.data)
                resultObservable.onNext(UseCaseResult.Success(data = results.toList()))
            } else {
                resultObservable.onNext(it)
            }

            resultObservable
        }
    }

    abstract fun loadPage(params: Params?, page: Int, pageSize: Int): Observable<List<T>>

    fun nextPage() {
        page++
        pagination.onNext(page)
    }

    fun currentList(): List<T> {
        return results.toList()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun setList(list: List<T>) {
        results.clear()
        results.addAll(list)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun setResetPage(resetPage: Boolean) {
        this.resetPage = resetPage
    }
}