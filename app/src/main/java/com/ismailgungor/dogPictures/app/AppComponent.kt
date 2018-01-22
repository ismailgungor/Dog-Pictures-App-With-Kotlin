package com.ismailgungor.dogPictures.app

import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 20.01.2018.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

}