package com.ismailgungor.dogPictures.dogPicturesActivity

import android.content.Intent
import com.google.gson.JsonObject
import com.ismailgungor.dogPictures.helper.callbackHelper.DogApiCallbackHelper
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.repository.DogApiRepository
import com.ismailgungor.dogPictures.service.IServiceResponseCallback
import com.ismailgungor.dogPictures.util.IntentKeys
import javax.inject.Inject

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogPicturesActivityPresenter @Inject constructor(dogRepo: DogApiRepository,
                                                       dogApiCallbackHelper: DogApiCallbackHelper) : DogPicturesActivityContract.Presenter {


    private lateinit var mView: DogPicturesActivityContract.View
    private var mDogRepo: DogApiRepository = dogRepo
    private var mDogApiCallbackHelper = dogApiCallbackHelper

    override fun setView(view: DogPicturesActivityContract.View) {
        this.mView = view
    }

    override fun controlDogModelFromIntent(intent: Intent) {

        if (intent.hasExtra(IntentKeys.BUNDLE) && intent.getBundleExtra(IntentKeys.BUNDLE).containsKey(IntentKeys.DOG_MODEL)) {

            val dogModel = intent.getBundleExtra(IntentKeys.BUNDLE).getParcelable<DogMainModel>(IntentKeys.DOG_MODEL) as DogMainModel
            this.mView.setDogName(dogModel.getName())
            this.mView.setDogImage(dogModel.getImageUrl())

        }
    }

    override fun getAnotherDogImage(dogName: String) {

        mDogRepo.getDogImageUrl(dogName, object : IServiceResponseCallback<JsonObject> {
            override fun onSuccess(jsonObject: JsonObject) {

                if (!jsonObject.isJsonNull) {

                    val imageUrl = mDogApiCallbackHelper.getDogImageUrlFromJson(jsonObject)
                    mView.setDogImage(imageUrl)

                }

            }

            override fun onFailed(error: Throwable) {
            }

        })

    }

}