package com.example.f.submision3.view.match

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import com.example.f.submision3.data.local.DbOpenHelper
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.util.SchedulerProviders
import com.example.f.submision3.view.base.BaseViewModel
import com.example.f.submission3.model.EventsItem
import com.example.f.submission3.model.TeamsItem
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

open class MatchViewModel: BaseViewModel() {
    var isFavorite:Boolean = false

//    override fun injector(componentDagger: ComponentDagger) {
//        componentDagger.inject(this)
//    }

    init {
        matchRepository.matchRemoteData.adapter = matchAdapter

        matchRepository.matchRemoteData.loading = loading
        matchRepository.matchRemoteData.rvVisibility = rvVisibility
        matchRepository.matchRemoteData.network = network
        matchRepository.matchRemoteData.compositeDisposable = compositeDisposable

        matchRepository.matchRemoteData.providerSchedulers = SchedulerProviders.SchedulerProvider()
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


    fun showFavorite(context: Context?) {
        DbOpenHelper(context!!).use {
            val result = select(EventsItem.favorite)
            val fav = result.parseList(classParser<EventsItem>())


            matchAdapter.updateData(fav)

            loading.value = false
            rvVisibility.value = true

            matchAdapter.notifyDataSetChanged()

        }
    }


    //fungsi tambah ke db favorite
    fun addToFav(db:DbOpenHelper,context: Context?,extra:EventsItem){

        val homeBadge = getTeam(extra.idHomeTeam.toString())
        val awayBadge = getTeam(extra.idAwayTeam.toString())

        try{
            db.use{
                insert(EventsItem.favorite,

                        EventsItem.ID_EVENT to extra.idEvent,
                        EventsItem.intHomeShots to extra.intHomeShots,
                        EventsItem.strHomeLineupDefense to extra.strHomeLineupDefense,
                        EventsItem.strAwayLineupSubstitutes to extra.strAwayLineupSubstitutes,
                        EventsItem.strHomeLineupForward to extra.strHomeLineupForward,
                        EventsItem.strHomeGoalDetails to extra.strHomeGoalDetails,
                        EventsItem.strAwayLineupGoalkeeper to extra.strAwayLineupGoalkeeper,
                        EventsItem.strAwayLineupMidfield to extra.strAwayLineupMidfield,
                        EventsItem.strHomeYellowCards to extra.strHomeYellowCards,
                        EventsItem.IDHOMETEAM to extra.idHomeTeam,
                        EventsItem.INTHOMESCORE to extra.intHomeScore,
                        EventsItem.dateEvent to extra.dateEvent,
                        EventsItem.STRAWAYTEAM to extra.strAwayTeam,
                        EventsItem.strHomeLineupMidfield to extra.strHomeLineupMidfield,
                        EventsItem.strHomeFormation to extra.strHomeFormation,
                        EventsItem.IDAWAYTEAM to extra.idAwayTeam,
                        EventsItem.strAwayRedCards to extra.strAwayRedCards,
                        EventsItem.intAwayShots to extra.intAwayShots,
                        EventsItem.strAwayGoalDetails to extra.strAwayGoalDetails,
                        EventsItem.strAwayLineupForward to extra.strAwayLineupForward,
                        EventsItem.strHomeRedCards to extra.strHomeRedCards,
                        EventsItem.strHomeLineupGoalkeeper to extra.strHomeLineupGoalkeeper,
                        EventsItem.strHomeLineupSubstitutes to extra.strHomeLineupSubstitutes,
                        EventsItem.strAwayFormation to extra.strAwayFormation,
                        EventsItem.strAwayYellowCards to extra.strAwayYellowCards,
                        EventsItem.strAwayLineupDefense to extra.strAwayLineupDefense,
                        EventsItem.STRHOMETEAM to extra.strHomeTeam,
                        EventsItem.INTAWAYSCORE to extra.intAwayScore,
                        EventsItem.homeBadgeTeam to homeBadge,
                        EventsItem.awayBadgeTeam to awayBadge
                )
                Toast.makeText(context?.applicationContext,"added to fav ${extra.idEvent}", Toast.LENGTH_SHORT).show()
            }
        } catch (e: SQLiteConstraintException){
            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun removeFromFav(db: DbOpenHelper,context: Context?,extra:EventsItem){
        try {
           db.use {
                delete(EventsItem.favorite,"(iE = {id})","id" to extra.idEvent!!)

                Toast.makeText(context?.applicationContext,"remove from fav", Toast.LENGTH_SHORT).show()
            }

        }catch (e: SQLiteConstraintException){
            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun favoriteState(db: DbOpenHelper,id:String?){
        db.use {
            val result = select(EventsItem.favorite).whereArgs("(iE = {id})",
                    "id" to id!!)
            val fav = result.parseList(classParser<EventsItem>())

            if (fav.isNotEmpty()){
                isFavorite = true
            }

        }
    }
}