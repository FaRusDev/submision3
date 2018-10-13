package com.example.f.submision3.di.module

import android.support.test.espresso.idling.CountingIdlingResource
import com.example.f.submision3.network.Network
import com.example.f.submision3.util.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{


    var idlingResource: CountingIdlingResource = CountingIdlingResource("Network_Calls")

    @Provides
    @Singleton
    fun providesGsonService(retrofit: Retrofit):Network{
        return retrofit.create(Network::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}