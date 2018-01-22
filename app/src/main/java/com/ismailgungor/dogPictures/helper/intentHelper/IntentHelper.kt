package com.ismailgungor.dogPictures.helper.intentHelper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ismailgungor.dogPictures.dogPicturesActivity.DogPicturesActivity
import com.ismailgungor.dogPictures.dogsActivity.DogsActivity
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.util.IntentKeys

/**
 * Created by ismailgungor on 20.01.2018.
 */
class IntentHelper(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context
    }

    fun getDogImageActivityIntent(dogModel: DogMainModel): Intent {
        val intent = Intent(mContext, DogPicturesActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(IntentKeys.DOG_MODEL, dogModel)
        intent.putExtra(IntentKeys.BUNDLE, bundle)
        return intent
    }

    fun getDogActivityIntentFromSplash(dogModelList: ArrayList<DogMainModel>): Intent {
        val intent = Intent(mContext, DogsActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelableArrayList(IntentKeys.DOG_MODEL_LIST, dogModelList)
        intent.putExtra(IntentKeys.BUNDLE, bundle)
        return intent
    }

}