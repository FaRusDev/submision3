package com.example.f.submision3.util

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.view.match.MatchAdapter
import com.example.f.submision3.view.match.MatchViewModel
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable


@BindingAdapter("app:visibility")
fun mutableVisibility(v: View, visible:Boolean){
    v.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("app:rvAdapter")
fun mutableAdapter(rv: RecyclerView,adapter: RecyclerView.Adapter<*>){
    rv.adapter = adapter
}


@BindingAdapter("app:imgRes")
fun mutableImage(imageView: ImageView,id:String){

    //TODO:ini ada gak cara yang lebih simple kyk import dari MatchViewModel ? udah coba-coba tapi masih aja gagal
    //satu-satunya cara yang berhasil smapi skarang pake ini


    val retrofit = NetworkModule().providesRetrofit()
    val network = NetworkModule().providesGsonService(retrofit)

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val rvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    val matchAdapter = MatchAdapter()

    var compositeDisposable = CompositeDisposable()

        val matchRemoteData = object :MatchRemoteData(){
            override fun subscribeTeamSuccess(team: Team) {
                Picasso.get().load(team.teams?.get(0)?.strTeamBadge).into(imageView)
            }
        }

    matchRemoteData.adapter = matchAdapter
    matchRemoteData.loading = loading
    matchRemoteData.rvVisibility = rvVisibility
    matchRemoteData.network = network
    matchRemoteData.compositeDisposable = compositeDisposable

    matchRemoteData.getTeam(id)

}
