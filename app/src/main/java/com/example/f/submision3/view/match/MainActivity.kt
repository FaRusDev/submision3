package com.example.f.submision3.view.match

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.example.f.submision3.R
import com.example.f.submision3.databinding.ActivityMainBinding
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.view.base.BaseActivity
import io.reactivex.disposables.CompositeDisposable

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

        //setViewModel
        viewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        //set variable untuk xml
        mainBinding.mainMatch = viewModel

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getNextMatch()
    }
}
