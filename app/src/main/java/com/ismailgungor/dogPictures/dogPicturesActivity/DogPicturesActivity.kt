package com.ismailgungor.dogPictures.dogPicturesActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.ismailgungor.dogPictures.app.AppModule
import com.ismailgungor.dogPictures.dogsActivity.R
import com.ismailgungor.dogPictures.dogsActivity.R2
import com.squareup.picasso.Picasso
import javax.inject.Inject

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogPicturesActivity : AppCompatActivity(), DogPicturesActivityContract.View {

    private var dogName: String? = null

    @BindView(R2.id.tv_dog_name)
    lateinit var tvDogName: TextView

    @BindView(R2.id.iv_dog_image)
    lateinit var ivDogImage: ImageView

    @Inject
    lateinit var mPresenter: DogPicturesActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_dog_images)

        DaggerDogPicturesActivityComponent.builder()
                .appModule(AppModule(this))
                .build().inject(this)

        ButterKnife.bind(this)
        this.mPresenter.setView(this)
        this.mPresenter.controlDogModelFromIntent(intent)

    }

    override fun setDogName(dogName: String) {

        this.dogName = dogName
        this.tvDogName.text = getString(R.string.dog_breed, dogName.toUpperCase())

    }

    override fun setDogImage(dogImageUrl: String) {

        Picasso.with(this).load(dogImageUrl).error(R.drawable.empty_iimage).into(ivDogImage)

    }

    fun getAnotherOne(view: View) {

        dogName?.let { this.mPresenter.getAnotherDogImage(it) }

    }


}