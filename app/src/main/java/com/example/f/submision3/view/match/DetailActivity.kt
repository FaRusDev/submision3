package com.example.f.submision3.view.match

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.example.f.submision3.R
import com.example.f.submision3.R.id.add_to_fav
import com.example.f.submision3.R.menu.detail_menu
import com.example.f.submision3.data.local.database
import com.example.f.submision3.databinding.ActivityDetailBinding
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.util.CustomViewModelFactory
import com.example.f.submision3.util.EXTRA_MATCH
import com.example.f.submision3.view.base.BaseActivity
import com.example.f.submission3.model.EventsItem
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class DetailActivity:BaseActivity<ActivityDetailBinding,MatchViewModel>() {



    override fun inject(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    override fun setLayoutResource(): Int = R.layout.activity_detail

    lateinit var extra:EventsItem
    private var menuItem:Menu? = null

    override fun code() {
        //ini ambil data pake parcelable
        extra = intent.extras.getParcelable(EXTRA_MATCH)

        mainBinding.setLifecycleOwner(this)
        mainBinding.xmlDetail = extra
        val matchRepository = MatchRepository()

        //setViewModel
        viewModel = ViewModelProviders.of(this, CustomViewModelFactory(matchRepository)).get(MatchViewModel::class.java)

        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favState()

    }

    fun setFavorite(){
        if (viewModel.isFavorite){
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_has_added_to_fav)
        } else{
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_add_to_fav)
        }
    }

    fun favState(){

        val x = database.use {
            val n = select(EventsItem.favorite).whereArgs("iE = {id}","id" to extra.idEvent!!)
            val fav = n.parseList(classParser<EventsItem>())

            return@use fav
        }

        if(x.isNotEmpty()){
            if (x.get(0).idEvent == extra.idEvent){
                viewModel.favoriteState(database,extra.idEvent)
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu,menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            add_to_fav->{
                if (viewModel.isFavorite){
                   viewModel.removeFromFav(database,this,extra)
                    finish()
                }else{
                    viewModel.addToFav(database,this,extra)
                }

                viewModel.isFavorite = !viewModel.isFavorite
                setFavorite()

                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

}