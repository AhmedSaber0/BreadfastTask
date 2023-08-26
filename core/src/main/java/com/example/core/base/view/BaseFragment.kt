package com.example.core.base.view

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.event.EventObserver
import com.example.core.extension.getThemeColor
import com.example.core.navigation.CoordinatorEvent
import com.example.core.viewstate.ViewAction
import com.example.core.viewstate.ViewEvent
import com.example.core.viewstate.ViewState

abstract class BaseFragment<
    VS : ViewState,
    VE : ViewEvent,
    VA : ViewAction,
    CE : CoordinatorEvent,
    VM : BaseViewModel<VS, VE, VA, CE>,
    VB : ViewBinding
    > : Fragment() {

    protected abstract val viewModel: VM

    @get:StyleRes
    protected abstract val fragmentTheme: Int

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // create ContextThemeWrapper from the original Activity Context with the custom theme.
        val contextThemeWrapper: Context = ContextThemeWrapper(requireActivity(), fragmentTheme)

        // clone the inflater using the ContextThemeWrapper.
        val localInflater = inflater.cloneInContext(contextThemeWrapper)

        val color = contextThemeWrapper.getThemeColor(android.R.attr.colorBackground)
        requireActivity().window.setBackgroundDrawable(ColorDrawable(color))

        _binding = onCreateBinding(localInflater, container)
        return binding.root
    }

    abstract fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner) { renderViewState(it) }
        viewModel.viewEvent.observe(viewLifecycleOwner, EventObserver { renderViewEvent(it) })
        viewModel.coordinatorEvent.observe(
            viewLifecycleOwner,
            EventObserver { coordinatorEvent(it) }
        )
    }

    abstract fun renderViewState(viewState: VS)

    abstract fun renderViewEvent(viewEvent: VE)

    abstract fun coordinatorEvent(coordinatorEvent: CE)

    protected fun postAction(action: VA) {
        viewModel.postAction(action)
    }

    fun View.postClickAction(action: VA) {
        setOnClickListener { postAction(action) }
    }

    fun View.postClickAction(action: () -> VA) {
        setOnClickListener { postAction(action.invoke()) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
