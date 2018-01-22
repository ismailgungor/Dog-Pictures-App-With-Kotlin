package com.ismailgungor.dogPictures.app

import android.app.Application

/**
 * Created by ismailgungor on 20.01.2018.
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

    }

}