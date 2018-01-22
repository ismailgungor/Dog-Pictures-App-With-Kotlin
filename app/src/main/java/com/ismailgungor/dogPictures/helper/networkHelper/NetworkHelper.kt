package com.ismailgungor.dogPictures.helper.networkHelper

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by ismailgungor on 22.01.2018.
 */
class NetworkHelper(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context
    }

    fun isNetworkConnected(): Boolean {

        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (connectivityManager.activeNetworkInfo != null) {
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo.isConnected
        } else {
            return false
        }

    }
}