package com.example.core.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.event.Event
import com.example.core.extension.asLiveData
import com.example.core.viewstate.ViewAction
import com.example.core.viewstate.ViewEvent
import com.example.core.viewstate.ViewState

abstract class BaseViewModel<VS : ViewState, VE : ViewEvent, VA : ViewAction> :
    ViewModel() {

    abstract val initViewState: VS

    private val _viewState = MutableLiveData<VS>()
    val viewState = _viewState.asLiveData()

    private val _viewEvent = MutableLiveData<Event<VE>>()
    val viewEvent = _viewEvent.asLiveData()

    abstract fun postAction(action: VA)

    fun currentViewState(): VS {
        return viewState.value ?: initViewState
    }

    protected fun updateViewState(state: VS) {
        _viewState.value = state
    }

    protected fun updateViewEvent(event: VE) {
        _viewEvent.value = Event(event)
    }
}
