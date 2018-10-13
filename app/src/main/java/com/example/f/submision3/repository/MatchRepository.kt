package com.example.f.submision3.repository

import android.arch.lifecycle.MutableLiveData
import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import com.example.f.submission3.model.TeamsItem


open class MatchRepository{

    var x:TeamsItem? = null


    var matchRemoteData:MatchRemoteData = object : MatchRemoteData(){
        override fun subscribeTeamSuccess(team: Team) {
            x = team.teams?.get(0)
        }

        override fun onSubscribe()
            {
                rvVisibility.value = false
                loading.value = true
            }

        override fun onCompleteSubscribe()     {
            loading.value = false
            rvVisibility.value = true

            //penambahan idle resource
            idlingResource.decrement()
        }

        override fun subscribeSuccess(match: Match)     {
            adapter.updateData(match.events)
        }

    }

    val loading: MutableLiveData<Boolean> = matchRemoteData.loading
    val rvVisibility: MutableLiveData<Boolean> = matchRemoteData.rvVisibility
    val adapter= matchRemoteData.adapter
    var providerSchedulers = matchRemoteData.providerSchedulers

    //rencananya class ini utntuk periksa koneksi klo koneksinya ada fungsinya bakal kurang lebih kyk gini
//
//    fun getNextMatch(){
//        if(isConnected){
//            matchRemoteData.getNextMatch()
//        }else{matchLocalData.getNextMatch()}
//    }

    fun getNextMatch(){
       matchRemoteData.getNextMatch()
    }

    fun getLastMatch(){
        matchRemoteData.getLastMatch()
    }

    fun getTeam(id:String): TeamsItem? {
        matchRemoteData.getTeam(id)
        return x
    }

}