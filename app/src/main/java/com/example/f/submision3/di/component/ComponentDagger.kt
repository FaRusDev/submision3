package com.example.f.submision3.di.component

import com.example.f.submision3.di.module.AppModule
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.view.match.DetailActivity
import com.example.f.submision3.view.match.*
import com.example.f.submision3.view.match.fragment.FavouriteMatchFragment
import com.example.f.submision3.view.match.fragment.LastMatchFragment
import com.example.f.submision3.view.match.fragment.NextMatchFragment
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

    fun inject(mainActivity: MainActivity)
    fun inject(detailMatchActivity: DetailActivity)
    fun inject(nextMatchFragment: NextMatchFragment)
    fun inject(lastMatchFragment: LastMatchFragment)
    fun inject(favouriteMatchFragment: FavouriteMatchFragment)

}