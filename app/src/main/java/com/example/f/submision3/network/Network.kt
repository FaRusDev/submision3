package com.example.f.submision3.network

import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Network {
    @GET("eventsnextleague.php?id=4328")
    fun getNextMatch():Observable<Match>

    @GET("eventspastleague.php?id=4328")
    fun getLastMatch(): Observable<Match>

    @GET("lookupteam.php")
    fun getTeam(@Query("id")id:String):Observable<Team>
}