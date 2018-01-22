package com.ismailgungor.dogPictures.service

/**
 * Created by ismailgungor on 20.01.2018.
 */
interface IServiceResponseCallback<T> {

    fun onSuccess(jsonObject: T)

    fun onFailed(error: Throwable)
}