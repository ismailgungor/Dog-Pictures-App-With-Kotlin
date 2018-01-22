package com.ismailgungor.dogPictures.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ismailgungor on 20.01.2018.
 */
class ApiFactory {


    companion object {

        private var retrofit: Retrofit? = null

        fun <T> create(retroClass: Class<T>): T {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://dog.ceo/api/")
                        .build()

            }

            return retrofit!!.create(retroClass)
        }


    }

}