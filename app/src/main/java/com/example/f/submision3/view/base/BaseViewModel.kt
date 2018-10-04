package com.example.f.submision3.view.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.view.match.MatchAdapter
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel:ViewModel() {

    //TODO: ini cara injeksinya saya masih belum mengerti jadi saya buatkan instance supaya bisa terpanggil
    val retrofit = NetworkModule().providesRetrofit()
    var network = NetworkModule().providesGsonService(retrofit)


    val matchRepository: MatchRepository = MatchRepository()

    //komponen dari data binding
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val rvVisibility: MutableLiveData<Boolean> = MutableLiveData()
    var matchAdapter: MatchAdapter = MatchAdapter()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

//    //nanti diperbarui di matchviewmodel
//    abstract fun injector(componentDagger: ComponentDagger)
//
//    private var daggerComponent = DaggerApp.componentDagger
//
//    init {
//        injector(daggerComponent)
//    }

}