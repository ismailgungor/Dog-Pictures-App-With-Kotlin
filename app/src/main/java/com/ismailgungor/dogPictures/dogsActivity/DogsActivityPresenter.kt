package com.ismailgungor.dogPictures.dogsActivity

import android.content.Intent
import com.ismailgungor.dogPictures.helper.intentHelper.IntentHelper
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.util.IntentKeys

import javax.inject.Inject

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogsActivityPresenter @Inject constructor(intentHelper: IntentHelper) : DogsActivityContract.Presenter {

    private lateinit var mView: DogsActivityContract.View

    private var mIntentHelper = intentHelper


    override fun setView(view: DogsActivityContract.View) {

        this.mView = view

    }

    override fun controlDogMdelListFromIntent(intent: Intent) {

        if (intent.hasExtra(IntentKeys.BUNDLE) && intent.getBundleExtra(IntentKeys.BUNDLE).containsKey(IntentKeys.DOG_MODEL_LIST)) {

            val dogModelList = intent.getBundleExtra(IntentKeys.BUNDLE).getParcelableArrayList<DogMainModel>(IntentKeys.DOG_MODEL_LIST) as ArrayList<DogMainModel>
            this.mView.setDogListAdapter(dogModelList)

        }

    }

    override fun goDogImageActivity(dogModel: DogMainModel) {

        mView.goDogImageActivity(mIntentHelper.getDogImageActivityIntent(dogModel))


    }


}