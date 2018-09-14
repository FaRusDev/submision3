package com.example.f.submision3.network

import android.content.Context
import android.net.ConnectivityManager

class Connectivity(private val context: Context) {

   private var status:Boolean? = false

    val isConnectedToInet : Boolean?
    get() {
      val conManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      val netStatus = conManager.activeNetworkInfo
      return netStatus != null && netStatus.isConnected
    }

}
