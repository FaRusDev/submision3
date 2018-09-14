package com.example.f.submision3.di.module

import android.app.Application
import android.content.Context
import com.example.f.submision3.di.DaggerApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val daggerApp:DaggerApp) {

    @Provides
    @Singleton
    fun providesApplication():Application{
        return daggerApp
    }

    @Provides
    @Singleton
    fun providesContext():Context{
        return daggerApp
    }

}