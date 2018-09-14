package com.example.f.submision3.view.match

import android.arch.lifecycle.MutableLiveData
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.network.Network
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.view.base.BaseViewModel
import com.example.f.submission3.model.Match
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class MatchViewModel: BaseViewModel() {

    val matchRepository:MatchRepository = MatchRepository()

    //komponen dari data binding
    val loading:MutableLiveData<Boolean> = MutableLiveData()
    val rvVisibility:MutableLiveData<Boolean> = MutableLiveData()
    val matchAdapter: MatchAdapter = MatchAdapter()
    var compositeDisposable:CompositeDisposable = CompositeDisposable()

    override fun injector(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    init {
        matchRepository.matchRemoteData.adapter = matchAdapter
        matchRepository.matchRemoteData.loading = loading
        matchRepository.matchRemoteData.rvVisibility = rvVisibility
        matchRepository.matchRemoteData.compositeDisposable = compositeDisposable
    }

    fun getNextMatch(){
        matchRepository.getNextMatch()
    }

    fun getLastMatch(){
        matchRepository.getLastMatch()
    }

}