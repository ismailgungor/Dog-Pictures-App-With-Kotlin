package com.ismailgungor.dogPictures.service

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ismailgungor on 20.01.2018.
 */
interface DogApiService {

    @GET("breeds/list")
    fun getDogNames(): Call<JsonObject>

    @GET("breed/{name}/images/random")
    fun getDogImageUrl(@Path("name") dogName: String): Call<JsonObject>

}