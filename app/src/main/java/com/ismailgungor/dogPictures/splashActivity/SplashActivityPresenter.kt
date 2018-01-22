package com.ismailgungor.dogPictures.splashActivity

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.ismailgungor.dogPictures.helper.callbackHelper.DogApiCallbackHelper
import com.ismailgungor.dogPictures.helper.intentHelper.IntentHelper
import com.ismailgungor.dogPictures.helper.networkHelper.NetworkHelper
import com.ismailgungor.dogPictures.helper.preferencesHelper.ISharedPreferencesManagement
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.repository.DogApiRepository
import com.ismailgungor.dogPictures.service.IServiceResponseCallback
import com.ismailgungor.dogPictures.util.PreferencesKeys
import javax.inject.Inject

/**
 * Created by ismailgungor on 22.01.2018.
 */
class SplashActivityPresenter @Inject constructor(networkHelper: NetworkHelper,
                                                  dogRepo: DogApiRepository,
                                                  dogApiCallbackHelper: DogApiCallbackHelper,
                                                  iSharedPreferencesManagement: ISharedPreferencesManagement,
                                                  gson: Gson,
                                                  intentHelper: IntentHelper) : SplashActivityContract.Presenter {

    private lateinit var mView: SplashActivityContract.View
    private var mNetworkHelper = networkHelper
    private var mDogRepo: DogApiRepository = dogRepo
    private var mDogApiCallbackHelper = dogApiCallbackHelper
    private var mDefaultSharedPreferences: ISharedPreferencesManagement = iSharedPreferencesManagement

    private var mDogModels = ArrayList<DogMainModel>()
    private var mDogNames: ArrayList<String> = ArrayList<String>()

    private var mGson: Gson = gson
    private var mIntentHelper = intentHelper


    override fun setView(view: SplashActivityContract.View) {

        this.mView = view

    }

    override fun checkNetwork() {

        val isNetworkConnected = this.mNetworkHelper.isNetworkConnected()

        if (isNetworkConnected) {

            this.mView.getDogNames()

        } else {

            this.mView.showNetworkNotConnectedDialog()

        }

    }

    override fun getDogNames() {

        this.mView.showLoadingView()
        val areThereDogModels = mDefaultSharedPreferences.getAsBoolean(PreferencesKeys.ARE_THERE_DOG_MODELS, false)

        if (areThereDogModels) {

            val dogModels = mDefaultSharedPreferences.getAsString(PreferencesKeys.DOG_MODELS, "")
            if (dogModels != "") {

                mDogModels = mGson.fromJson(dogModels, object : TypeToken<ArrayList<DogMainModel>>() {}.type)
                mView.hideLoadingView()
                mView.goToDogsActivity(this.mIntentHelper.getDogActivityIntentFromSplash(mDogModels))


            }

        } else {

            mDogRepo.getAllDogNames(object : IServiceResponseCallback<JsonObject> {

                override fun onSuccess(jsonObject: JsonObject) {

                    if (!jsonObject.isJsonNull) {

                        mDogNames = mDogApiCallbackHelper.getDogNamesFromJson(jsonObject)

                        getImageUrl(mDogNames)

                    }
                }

                override fun onFailed(error: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
        }

    }

    fun getImageUrl(dogNameList: ArrayList<String>) {

        if (dogNameList.isNotEmpty() && dogNameList.size > 0) {

            mDogRepo.getDogImageUrl(dogNameList[0], object : IServiceResponseCallback<JsonObject> {

                override fun onSuccess(jsonObject: JsonObject) {

                    if (!jsonObject.isJsonNull) {

                        val dogImageUrl = mDogApiCallbackHelper.getDogImageUrlFromJson(jsonObject)
                        mDogModels.add(DogMainModel(dogNameList[0], dogImageUrl))
                        dogNameList.removeAt(0)
                        getImageUrl(dogNameList)

                    }

                }

                override fun onFailed(error: Throwable) {
                    getImageUrl(dogNameList)
                }


            })

        } else {
            mDefaultSharedPreferences.setAsBoolean(PreferencesKeys.ARE_THERE_DOG_MODELS, true)
            mDefaultSharedPreferences.setAsString(PreferencesKeys.DOG_MODELS, mGson.toJson(mDogModels))
            mView.hideLoadingView()
            mView.goToDogsActivity(this.mIntentHelper.getDogActivityIntentFromSplash(mDogModels))

        }

    }

}