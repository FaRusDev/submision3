package com.example.f.submision3.repository

import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submission3.model.Team
import com.example.f.submission3.model.TeamsItem


class MatchRepository{

    var x:TeamsItem? = null

    var matchRemoteData:MatchRemoteData = object : MatchRemoteData(){
        override fun subscribeTeamSuccess(team: Team) {
            x = team.teams?.get(0)
        }
    }

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