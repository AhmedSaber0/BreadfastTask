package com.example.posts.presentation.splash.viewmodel

import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.viewstate.EmptyViewAction
import com.example.core.viewstate.EmptyViewEvent
import com.example.core.viewstate.EmptyViewState
import com.example.posts.presentation.splash.viewstate.SplashCoordinatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() :
    BaseViewModel<EmptyViewState, EmptyViewEvent, EmptyViewAction, SplashCoordinatorEvent>() {

    override val initViewState: EmptyViewState
        get() = throw NotImplementedError()

    override fun postAction(action: EmptyViewAction) {
        throw NotImplementedError()
    }
}
