package com.example.f.submision3.di

import android.app.Application
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.di.component.DaggerComponentDagger
import com.example.f.submision3.di.module.AppModule
import com.example.f.submision3.di.module.NetworkModule

class DaggerApp: Application() {

    companion object {
        lateinit var componentDagger:ComponentDagger
    }

    override fun onCreate() {
        super.onCreate()
        componentDagger = DaggerComponentDagger.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}