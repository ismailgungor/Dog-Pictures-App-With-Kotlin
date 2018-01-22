package com.ismailgungor.dogPictures.app

import android.content.Context
import com.ismailgungor.dogPictures.helper.callbackHelper.DogApiCallbackHelper
import com.ismailgungor.dogPictures.repository.DogApiRepository
import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 20.01.2018.
 */
@Module
class AppModule(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context
    }

    @Provides
    fun provideContext(): Context {

        return this.mContext
    }

    @Provides
    fun provideDogApiRepository(): DogApiRepository {
        return DogApiRepository()
    }

    @Provides
    fun provideDogApiCallbackHelper(): DogApiCallbackHelper {
        return DogApiCallbackHelper()
    }

}