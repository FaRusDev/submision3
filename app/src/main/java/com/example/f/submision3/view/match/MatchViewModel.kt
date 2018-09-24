package com.example.f.submision3.view.match

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import com.example.f.submision3.data.local.DbOpenHelper
import com.example.f.submision3.data.local.database
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.view.base.BaseViewModel
import com.example.f.submission3.model.EventsItem
import com.example.f.submission3.model.TeamsItem
import org.jetbrains.anko.db.*

open class MatchViewModel: BaseViewModel() {

    override fun injector(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    init {
        matchRepository.matchRemoteData.adapter = matchAdapter
        matchRepository.matchRemoteData.loading = loading
        matchRepository.matchRemoteData.rvVisibility = rvVisibility
        matchRepository.matchRemoteData.network = network
        matchRepository.matchRemoteData.compositeDisposable = compositeDisposable
    }

    fun getNextMatch(){
        matchRepository.getNextMatch()
    }

    fun getLastMatch(){
        matchRepository.getLastMatch()
    }

    fun getTeam(id:String): TeamsItem? {
        return matchRepository.getTeam(id)
    }

    var favorites :MutableList<EventsItem> = mutableListOf()
    fun showFavorite(ctx:Context){
        DbOpenHelper.getInstance(ctx).use {
            val result = select(EventsItem.favorite!!)
            val fav = result.parseList(classParser<EventsItem>())
            favorites.addAll(fav)
            matchAdapter.notifyDataSetChanged()
        }
    }

}