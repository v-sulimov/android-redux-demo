package com.vsulimov.reduxdemo

import android.os.Bundle
import android.view.ViewGroup
import com.vsulimov.android.activity.AppCompatActivity
import com.vsulimov.redux.Store
import com.vsulimov.reduxdemo.state.ApplicationState
import com.vsulimov.reduxdemo.view.CounterView

/**
 * Redux friendly activity which provides store for lifecycle actions dispatching
 * and also a container for [CounterView].
 */
class MainActivity : AppCompatActivity<ApplicationState>() {

    private lateinit var contentViewGroup: ViewGroup

    override fun getStore(): Store<ApplicationState> =
        AppComponent.store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewsById()
        addCounterView()
    }

    private fun findViewsById() {
        contentViewGroup = findViewById(R.id.contentViewGroup)
    }

    private fun addCounterView() {
        contentViewGroup.addView(CounterView(context = this))
    }
}
