package com.example.f.submision3.data.remote

import android.arch.lifecycle.MutableLiveData
import com.example.f.submision3.network.Network
import com.example.f.submision3.view.match.MatchAdapter
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class MatchRemoteData(){

    lateinit var network: Network
    lateinit var adapter: MatchAdapter
    lateinit var loading: MutableLiveData<Boolean>
    lateinit var rvVisibility: MutableLiveData<Boolean>
    lateinit var compositeDisposable:CompositeDisposable

    fun getNextMatch(){
        compositeDisposable.add(network.getNextMatch()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({onSubscribe()})
                .doOnComplete({onCompleteSubscribe()})
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getLastMatch(){
        compositeDisposable.add(network.getLastMatch()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({onSubscribe()})
                .doOnComplete({onCompleteSubscribe()})
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getTeam(id:String) {
       compositeDisposable.add(network.getTeam(id)
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .doOnSubscribe({onSubscribe()})
               .doOnComplete({onCompleteSubscribe()})
                .subscribe({
                    subscribeTeamSuccess(it)
                }))
    }

    fun onSubscribe()
    {
        rvVisibility.value = false
        loading.value = true
    }
    fun onCompleteSubscribe()
{
        loading.value = false
        rvVisibility.value = true
    }

    fun subscribeSuccess(match: Match)
    {
        adapter.updateData(match.events)
    }

   abstract fun subscribeTeamSuccess(team:Team)




}