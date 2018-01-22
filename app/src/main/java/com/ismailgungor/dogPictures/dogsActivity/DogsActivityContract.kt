package com.ismailgungor.dogPictures.dogsActivity

import android.content.Intent
import com.ismailgungor.dogPictures.model.DogMainModel

/**
 * Created by ismailgungor on 20.01.2018.
 */
interface DogsActivityContract {

    interface View {

        fun setDogListAdapter(dogList: ArrayList<DogMainModel>)

        fun goDogImageActivity(intent: Intent)


    }

    interface Presenter {

        fun setView(view: View)

        fun controlDogMdelListFromIntent(intent: Intent)

        fun goDogImageActivity(dogModel: DogMainModel)

    }

}