package com.vsulimov.reduxdemo.view

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vsulimov.redux.toolkit.SubStateSubscription
import com.vsulimov.reduxdemo.R
import com.vsulimov.reduxdemo.action.CounterAction
import com.vsulimov.reduxdemo.state.ApplicationState
import com.vsulimov.reduxdemo.util.dispatch
import com.vsulimov.reduxdemo.util.subscribe
import com.vsulimov.reduxdemo.util.unsubscribe

/**
 * Just a regular view for our single activity application.
 * The responsibilities of this view is pretty simple. It's inflate an xml, find all
 * necessary views, dispatch an actions when some event occurs and finally, subscribe to
 * the interesting part of the state and draw himself with the provided data.
 */
class CounterView(
    context: Context
) : FrameLayout(context) {

    private val counterSubscription = SubStateSubscription<ApplicationState, Int>(
        transform = { it.counter },
        onStateChange = { state: Int, _: Boolean -> handleCounterStateChange(state) }
    )

    private lateinit var counterTextView: TextView
    private lateinit var floatingActionButton: FloatingActionButton

    init {
        inflate(context, R.layout.view_counter, this)
        findViewsById()
        setOnClickListeners()
    }

    private fun findViewsById() {
        counterTextView = findViewById(R.id.counterTextView)
        floatingActionButton = findViewById(R.id.floatingActionButton)
    }

    private fun setOnClickListeners() {
        floatingActionButton.setOnClickListener { dispatch(CounterAction.Increment) }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        subscribeToStateChanges()
    }

    private fun subscribeToStateChanges() {
        subscribe(counterSubscription)
    }

    override fun onDetachedFromWindow() {
        unsubscribeFromStateChanges()
        super.onDetachedFromWindow()
    }

    private fun unsubscribeFromStateChanges() {
        unsubscribe(counterSubscription)
    }

    private fun handleCounterStateChange(state: Int) {
        counterTextView.text = state.toString()
    }
}
