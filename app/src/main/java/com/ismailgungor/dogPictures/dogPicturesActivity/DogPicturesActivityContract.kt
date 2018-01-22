package com.ismailgungor.dogPictures.dogPicturesActivity

import android.content.Intent

/**
 * Created by ismailgungor on 20.01.2018.
 */
interface DogPicturesActivityContract {

    interface View {

        fun setDogName(dogName: String)

        fun setDogImage(dogImageUrl: String)


    }

    interface Presenter {

        fun setView(view: View)

        fun controlDogModelFromIntent(intent: Intent)

        fun getAnotherDogImage(dogName: String)


    }

}