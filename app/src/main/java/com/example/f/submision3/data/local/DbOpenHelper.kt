package com.example.f.submision3.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.example.f.submission3.model.EventsItem
import kotlinx.coroutines.experimental.channels.NULL_VALUE
import org.jetbrains.anko.db.*
import javax.annotation.Nullable

class DbOpenHelper(context: Context):ManagedSQLiteOpenHelper(context,"EventsItem.db",null,1) {

    companion object {
        private var instance:DbOpenHelper? = null

        @Synchronized
        fun getInstance(ctx:Context):DbOpenHelper{
            if (instance == null){
                instance = DbOpenHelper(ctx.applicationContext)
            }
            return instance as DbOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(EventsItem.favorite!!,true,

                EventsItem.ID_EVENT!! to TEXT + UNIQUE + PRIMARY_KEY + NOT_NULL,
                EventsItem.IDHOMETEAM!! to TEXT ,
                EventsItem.STRHOMETEAM!! to TEXT ,
                EventsItem.intHomeShots!! to TEXT ,
                EventsItem.strHomeFormation!! to TEXT ,
                EventsItem.strHomeGoalDetails!! to TEXT ,
                EventsItem.strHomeLineupDefense!! to TEXT ,
                EventsItem.strHomeLineupForward!! to TEXT ,
                EventsItem.strHomeLineupGoalkeeper!! to TEXT ,
                EventsItem.strHomeLineupMidfield!! to TEXT ,
                EventsItem.strHomeLineupSubstitutes!! to TEXT ,
                EventsItem.strHomeRedCards!! to TEXT ,
                EventsItem.strHomeYellowCards!! to TEXT ,
                EventsItem.homeBadgeTeam!! to TEXT ,

                EventsItem.IDAWAYTEAM!! to TEXT ,
                EventsItem.STRAWAYTEAM!! to TEXT,
                EventsItem.intAwayShots!! to TEXT ,
                EventsItem.strAwayFormation!! to TEXT ,
                EventsItem.strAwayGoalDetails!! to TEXT ,
                EventsItem.strAwayLineupDefense!! to TEXT ,
                EventsItem.strAwayLineupForward!! to TEXT ,
                EventsItem.strAwayLineupGoalkeeper!! to TEXT ,
                EventsItem.strAwayLineupMidfield!! to TEXT ,
                EventsItem.strAwayLineupSubstitutes!! to TEXT ,
                EventsItem.strAwayRedCards!! to TEXT ,
                EventsItem.strAwayYellowCards!! to TEXT ,
                EventsItem.awayBadgeTeam!! to TEXT
                )

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
       db.dropTable(EventsItem.favorite!!,true)
    }
}

val Context.database: DbOpenHelper
    get() = DbOpenHelper.getInstance(applicationContext)


