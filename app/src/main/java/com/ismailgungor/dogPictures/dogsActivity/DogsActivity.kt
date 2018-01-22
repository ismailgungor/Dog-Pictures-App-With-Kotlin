package com.ismailgungor.dogPictures.dogsActivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.afollestad.materialdialogs.MaterialDialog
import com.ismailgungor.dogPictures.app.AppModule
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.rvAdapter.DogListAdapter
import javax.inject.Inject

class DogsActivity : AppCompatActivity(), DogsActivityContract.View {

    private var rvDogAdapter: DogListAdapter? = null
    private var dialog: MaterialDialog? = null


    @BindView(R2.id.rv_dogs)
    lateinit var rvDogs: RecyclerView

    @Inject
    lateinit var mPresenter: DogsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs)

        DaggerDogsActivityComponenet.builder()
                .appModule(AppModule(this))
                .dogsActivityModule(DogsActivityModule())
                .build().inject(this)

        ButterKnife.bind(this)
        this.mPresenter.setView(this)

        rvDogs.layoutManager = GridLayoutManager(this, 2)

        mPresenter.controlDogMdelListFromIntent(intent)

    }


    override fun setDogListAdapter(dogList: ArrayList<DogMainModel>) {

        rvDogAdapter = DogListAdapter(this, dogList, mPresenter)
        rvDogs.adapter = rvDogAdapter

    }

    override fun goDogImageActivity(intent: Intent) {
        startActivity(intent)
    }


}
