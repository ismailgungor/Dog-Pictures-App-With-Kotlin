package com.ismailgungor.dogPictures.repository

import com.google.gson.JsonObject
import com.ismailgungor.dogPictures.api.ApiFactory
import com.ismailgungor.dogPictures.service.DogApiService
import com.ismailgungor.dogPictures.service.IServiceResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogApiRepository {

    fun getAllDogNames(callback: IServiceResponseCallback<JsonObject>) {

        val dogApiService by lazy { ApiFactory.create(DogApiService::class.java) }
        val call = dogApiService.getDogNames()
        call.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                if (response?.body() != null) {
                    callback.onSuccess(response.body()!!)
                }

            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {

                if (t != null) {
                    callback.onFailed(t)
                }
            }


        })


    }

    fun getDogImageUrl(dogName: String, callback: IServiceResponseCallback<JsonObject>) {

        val dogApiService by lazy { ApiFactory.create(DogApiService::class.java) }
        val call = dogApiService.getDogImageUrl(dogName)
        call.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {

                if (response?.body() != null) {

                    callback.onSuccess(response.body()!!)

                }

            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {

                if (t != null) {
                    callback.onFailed(t)
                }
            }


        })

    }

}