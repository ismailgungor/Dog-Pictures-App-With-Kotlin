package com.ismailgungor.dogPictures.dogPicturesActivity

import com.ismailgungor.dogPictures.app.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 20.01.2018.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface DogPicturesActivityComponent {

    fun inject(dogPicturesActivity: DogPicturesActivity)

}