package com.example.f.submision3.data.remote

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.idling.CountingIdlingResource
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.util.SchedulerProviders
import com.example.f.submision3.view.match.TeamAdapter
import com.example.f.submission3.model.Team
import io.reactivex.disposables.CompositeDisposable

abstract class TeamRemoteData {

    var retrofit = NetworkModule().providesRetrofit()
    var network = NetworkModule().providesGsonService(retrofit)
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var adapter: TeamAdapter = TeamAdapter()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var rvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    var providerSchedulers: SchedulerProviders.BaseSchedulerProvider = SchedulerProviders.SchedulerProvider()

    var idlingResource: CountingIdlingResource = CountingIdlingResource("Network_Calls")

    fun getTeam(id:String) {
        idlingResource.increment()
        compositeDisposable.add(network.getTeam(id)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({
                    subscribeTeamSuccess(it)
                }))
    }

    abstract fun onSubscribe()

    abstract fun onCompleteSubscribe()

    abstract fun subscribeTeamSuccess(team: Team)

}