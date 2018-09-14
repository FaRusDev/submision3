package com.example.f.submision3.view.base

import android.arch.lifecycle.ViewModel
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.di.component.ComponentDagger

abstract class BaseViewModel:ViewModel() {


    //nanti diperbarui di matchviewmodel
    abstract fun injector(componentDagger: ComponentDagger)

    private val daggerComponent = DaggerApp.componentDagger

    init {
        injector(daggerComponent)
    }


}