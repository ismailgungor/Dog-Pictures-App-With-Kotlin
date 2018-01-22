package com.ismailgungor.dogPictures.dogsActivity

import android.content.Context
import com.ismailgungor.dogPictures.helper.intentHelper.IntentHelper
import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 20.01.2018.
 */
@Module
class DogsActivityModule {

    @Provides
    fun provideIntentIntent(context: Context): IntentHelper {
        return IntentHelper(context)
    }

}