package com.example.f.submision3.view.match

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.f.submision3.R
import com.example.f.submision3.databinding.RvItemBinding
import com.example.f.submision3.util.EXTRA_MATCH
import com.example.f.submission3.model.EventsItem

class MatchAdapter:RecyclerView.Adapter<MatchAdapter.MatchVH>() {
    lateinit var matchList: List<EventsItem?>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchVH =
           MatchVH(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.rv_item,parent,false))


    override fun getItemCount(): Int = matchList!!.size

    override fun onBindViewHolder(holder: MatchVH, position: Int) {
        holder.bindItem(matchList!![position])
    }

    //update data setiap ada koneksi
    fun updateData(list: List<EventsItem?>?){
        this.matchList = list!!
        notifyDataSetChanged()
    }


    inner class MatchVH(private val binding:RvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(list: EventsItem?) = with(binding.root){
            binding.bindingRv = list

            setOnClickListener {
//                itemView dari bawaan RecyclerView.ViewHolder cma disini tidak diinisialisasi
                //contextnya diambil dari itemview
                val i = Intent(itemView.context.applicationContext, DetailActivity::class.java)
                i.putExtra(EXTRA_MATCH,list)

                itemView.context.applicationContext.startActivity(i)
            }
        }


    }
}