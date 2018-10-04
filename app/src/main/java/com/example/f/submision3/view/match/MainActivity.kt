package com.example.f.submision3.view.match

import android.util.Log
import com.example.f.submision3.R
import com.example.f.submision3.databinding.ActivityMainBinding
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.view.base.BaseActivity
import com.example.f.submision3.view.match.fragment.FavouriteMatchFragment
import com.example.f.submision3.view.match.fragment.LastMatchFragment
import com.example.f.submision3.view.match.fragment.NextMatchFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:BaseActivity<ActivityMainBinding,MatchViewModel>() {
    private val compositeDisposable = CompositeDisposable()

    override fun inject(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    override fun setLayoutResource(): Int =
            R.layout.activity_main

    override fun code() {
        //setting lifecycle
        mainBinding.setLifecycleOwner(this)



        bottom_nav_view.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.nextMatchMenu -> {loadNextMatchFragment()
                Log.d("id",item.itemId.toString())
                }
                R.id.lastMatchMenu -> {loadLastMatchFragment()}
                R.id.favouriteMatchMenu -> {loadFavMatchFragment()}
            }
            true
        }
        bottom_nav_view.selectedItemId = R.id.nextMatchMenu
    }

    private fun loadNextMatchFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, NextMatchFragment(), NextMatchFragment::class.java.simpleName).commit()
    }

    private fun loadLastMatchFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, LastMatchFragment(), LastMatchFragment::class.java.simpleName).commit()
    }

    private fun loadFavMatchFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FavouriteMatchFragment(), FavouriteMatchFragment::class.java.simpleName).commit()
    }


}
