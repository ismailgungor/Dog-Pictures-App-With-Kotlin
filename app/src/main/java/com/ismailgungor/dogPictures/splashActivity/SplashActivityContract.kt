package com.ismailgungor.dogPictures.splashActivity

import android.content.Intent

/**
 * Created by ismailgungor on 22.01.2018.
 */
interface SplashActivityContract {

    interface View {

        fun showNetworkNotConnectedDialog()

        fun getDogNames()

        fun showLoadingView()

        fun hideLoadingView()

        fun goToDogsActivity(intent: Intent)

    }

    interface Presenter {

        fun setView(view: View)

        fun checkNetwork()

        fun getDogNames()


    }

}