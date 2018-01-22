package com.ismailgungor.dogPictures.splashActivity

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ismailgungor.dogPictures.helper.intentHelper.IntentHelper
import com.ismailgungor.dogPictures.helper.networkHelper.NetworkHelper
import com.ismailgungor.dogPictures.helper.preferencesHelper.DefaultSharedPreferences
import com.ismailgungor.dogPictures.helper.preferencesHelper.ISharedPreferencesManagement
import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 22.01.2018.
 */
@Module
class SplashActivityModule {

    @Provides
    fun provideNetworkHelper(context: Context): NetworkHelper {
        return NetworkHelper(context)
    }


    @Provides
    fun provideISharedPreferencesManagement(context: Context): ISharedPreferencesManagement {
        return DefaultSharedPreferences(context)
    }

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    fun provideIntentIntent(context: Context): IntentHelper {
        return IntentHelper(context)
    }

}