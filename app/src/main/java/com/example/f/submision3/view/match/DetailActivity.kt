package com.example.f.submision3.view.match

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.f.submision3.R
import com.example.f.submision3.R.id.add_to_fav
import com.example.f.submision3.R.menu.detail_menu
import com.example.f.submision3.data.local.database
import com.example.f.submision3.databinding.ActivityDetailBinding
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.util.EXTRA_MATCH
import com.example.f.submision3.view.base.BaseActivity
import com.example.f.submission3.model.EventsItem
import org.jetbrains.anko.db.*

class DetailActivity:BaseActivity<ActivityDetailBinding,MatchViewModel>() {

    override fun inject(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    override fun setLayoutResource(): Int = R.layout.activity_detail
    lateinit var extra:EventsItem

    override fun code() {
        //ini ambil data pake parcelable
        extra = intent.extras.getParcelable<EventsItem>(EXTRA_MATCH)

        mainBinding.setLifecycleOwner(this)
        mainBinding.xmlDetail = extra

        viewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)
        mainBinding.matchDetailXml = viewModel

        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (extra.idEvent != null){
            favoriteState(extra)
        }
    }

    private var menuItem:Menu? = null


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(detail_menu,menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            add_to_fav->{

                if (isFavorite){
                   removeFromFav(extra)
                }else{
                    addToFav(extra,this)
                }

                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setFavorite(){
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_has_added_to_fav)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_add_to_fav)
    }

    var isFavorite:Boolean = false


    //fungsi tambah ke db favorite
    fun addToFav(extra:EventsItem,context:Context){
        val homeBadge = viewModel.getTeam(extra.idHomeTeam.toString())
        val awayBadge = viewModel.getTeam(extra.idAwayTeam.toString())

        try{
            database.use{
                insert(EventsItem.favorite!!,
                        EventsItem.ID_EVENT!! to extra.idEvent,

                        EventsItem.IDHOMETEAM!! to extra.idHomeTeam,
                        EventsItem.STRHOMETEAM!! to extra.strHomeTeam,
                        EventsItem.intHomeShots!! to extra.intHomeShots,
                        EventsItem.strHomeFormation!! to extra.strHomeFormation,
                        EventsItem.strHomeGoalDetails!! to extra.strHomeGoalDetails,
                        EventsItem.strHomeLineupDefense!! to extra.strHomeLineupDefense,
                        EventsItem.strHomeLineupForward!! to extra.strHomeLineupForward,
                        EventsItem.strHomeLineupGoalkeeper!! to extra.strHomeLineupGoalkeeper,
                        EventsItem.strHomeLineupMidfield!! to extra.strHomeLineupMidfield,
                        EventsItem.strHomeLineupSubstitutes!! to extra.strHomeLineupSubstitutes,
                        EventsItem.strHomeRedCards!! to extra.strHomeRedCards,
                        EventsItem.strHomeYellowCards!! to extra.strHomeYellowCards,
                        EventsItem.homeBadgeTeam!! to homeBadge,

                        EventsItem.IDAWAYTEAM!! to extra.idAwayTeam,
                        EventsItem.STRAWAYTEAM!! to extra.strAwayTeam,
                        EventsItem.intAwayShots!! to extra.intAwayShots,
                        EventsItem.strAwayFormation!! to extra.strAwayFormation,
                        EventsItem.strAwayGoalDetails!! to extra.strAwayGoalDetails,
                        EventsItem.strAwayLineupDefense!! to extra.strAwayLineupDefense,
                        EventsItem.strAwayLineupForward!! to extra.strAwayLineupForward,
                        EventsItem.strAwayLineupGoalkeeper!! to extra.strAwayLineupGoalkeeper,
                        EventsItem.strAwayLineupMidfield!! to extra.strAwayLineupMidfield,
                        EventsItem.strAwayLineupSubstitutes!! to extra.strAwayLineupSubstitutes,
                        EventsItem.strAwayRedCards!! to extra.strAwayRedCards,
                        EventsItem.strAwayYellowCards!! to extra.strAwayYellowCards,
                        EventsItem.awayBadgeTeam!! to awayBadge
                )
                Toast.makeText(context.applicationContext,"added to fav ${extra.idEvent}", Toast.LENGTH_SHORT).show()
            }
        } catch (e: SQLiteConstraintException){
            Toast.makeText(context.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun removeFromFav(extra:EventsItem){
        try {
            database.use {
                delete(EventsItem.favorite!!,"(iE = {id})","id" to extra.idEvent.toString())

                Toast.makeText(applicationContext,"remove from fav", Toast.LENGTH_SHORT).show()
            }

        }catch (e: SQLiteConstraintException){
            Toast.makeText(applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun favoriteState(extra: EventsItem){
        database.use {
            val result = select(EventsItem.favorite!!).whereArgs("(iE = {id})",
                    "id" to extra.idEvent!!)
            val fav = result.parseList(classParser<EventsItem>())
            if (!fav.isEmpty())
                isFavorite = true
        }
    }

}