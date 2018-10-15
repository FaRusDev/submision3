package com.example.f.submision3.util

import android.support.test.espresso.IdlingResource


class EspressoIdlingRes {

    private val RESOURCE = "GLOBAL"

    private val mCountingIdlingResource = CostumCountingIdleRes(RESOURCE)

    val idlingResource: IdlingResource
        get() = mCountingIdlingResource

    fun increment() {
        mCountingIdlingResource.increment()
    }

    fun decrement() {
        mCountingIdlingResource.decrement()
    }
}