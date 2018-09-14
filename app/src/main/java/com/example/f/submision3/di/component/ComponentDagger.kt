package com.example.f.submision3.di.component

import com.example.f.submision3.di.module.AppModule
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.view.match.MainActivity
import com.example.f.submision3.view.match.MatchViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,NetworkModule::class])
interface ComponentDagger {

    @Component.Builder
    interface Builder{
        fun appModule(appModule: AppModule):Builder
        fun networkModule(networkModule: NetworkModule):Builder


        fun build():ComponentDagger
    }

    fun inject(matchViewModel: MatchViewModel)
    fun inject(mainActivity: MainActivity)

}