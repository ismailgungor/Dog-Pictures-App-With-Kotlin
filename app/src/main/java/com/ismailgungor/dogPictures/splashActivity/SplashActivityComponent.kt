package com.ismailgungor.dogPictures.splashActivity

import com.ismailgungor.dogPictures.app.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 22.01.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, SplashActivityModule::class))
interface SplashActivityComponent {

    fun inject(splashActivity: SplashActivity)

}