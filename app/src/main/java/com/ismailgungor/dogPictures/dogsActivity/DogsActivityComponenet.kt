package com.ismailgungor.dogPictures.dogsActivity

import com.ismailgungor.dogPictures.app.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 20.01.2018.
 */
@Singleton
@Component(modules = [(AppModule::class), (DogsActivityModule::class)])
interface DogsActivityComponenet {

    fun inject(dogsActivity: DogsActivity)

}