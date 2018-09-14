package com.example.f.submision3.repository

import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.network.Connectivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MatchRepository{
    @Inject
    lateinit var daggerApp:DaggerApp

    var matchRemoteData:MatchRemoteData = MatchRemoteData()
    var connectivity:Connectivity = Connectivity(daggerApp.applicationContext)

    fun getNextMatch(){
        if (connectivity.isConnectedToInet!!){
            matchRemoteData.getNextMatch()
        }
    }

    fun getLastMatch(){
        if (connectivity.isConnectedToInet!!){
            matchRemoteData.getLastMatch()
        }
    }

    fun getTeam(id:String){
        if (connectivity.isConnectedToInet!!){
            matchRemoteData.getTeam(id)
        }
    }


}