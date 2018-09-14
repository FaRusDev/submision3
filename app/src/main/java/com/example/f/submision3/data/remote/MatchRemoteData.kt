package com.example.f.submision3.data.remote

import android.arch.lifecycle.MutableLiveData
import com.example.f.submision3.network.Network
import com.example.f.submision3.view.match.MatchAdapter
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchRemoteData{

    @Inject
    lateinit var network: Network

    lateinit var adapter: MatchAdapter
    lateinit var loading: MutableLiveData<Boolean>
    lateinit var rvVisibility: MutableLiveData<Boolean>
    lateinit var compositeDisposable:CompositeDisposable

    fun getNextMatch(){
        compositeDisposable = network.getNextMatch()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({onSubscribe()})
                .doOnComplete({onCompleteSubscribe()})
                .subscribe({subscribeSuccess(it)},{}) as CompositeDisposable
    }

    fun getLastMatch(){
        compositeDisposable = network.getLastMatch()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({onSubscribe()})
                .doOnComplete({onCompleteSubscribe()})
                .subscribe({subscribeSuccess(it)},{}) as CompositeDisposable
    }

    fun getTeam(id:String){
        compositeDisposable = network.getTeam(id)
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .doOnSubscribe({onSubscribe()})
                .doOnComplete({onCompleteSubscribe()})
                .subscribe({subscribeTeamSuccess(it)},{}) as CompositeDisposable
    }

    fun onSubscribe(){
        rvVisibility.value = false
        loading.value = true
    }
    fun onCompleteSubscribe(){
        loading.value = false
        rvVisibility.value = true
    }
    fun subscribeSuccess(match: Match){
        adapter.updateData(match.events)
    }
    fun subscribeTeamSuccess(team:Team){
        adapter.setImage(team.teams)
    }

}