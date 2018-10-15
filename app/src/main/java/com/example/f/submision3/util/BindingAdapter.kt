package com.example.f.submision3.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import com.squareup.picasso.Picasso


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


        val matchRemoteData = object :MatchRemoteData(){
            override fun subscribeTeamSuccess(team: Team) {
                Picasso.get().load(team.teams?.get(0)?.strTeamBadge).into(imageView)
            }

            override fun onSubscribe()
            {
                rvVisibility.value = false
                loading.value = true
            }

            override fun onCompleteSubscribe()     {
                //penambahan idle resource
                if (!EspressoIdlingRes().idlingResource.isIdleNow){
                    EspressoIdlingRes().decrement()
                }

                loading.value = false
                rvVisibility.value = true
            }

            override fun subscribeSuccess(match: Match)     {
                adapter.updateData(match.events)
            }
        }

    matchRemoteData.getTeam(id)

}
