package com.ismailgungor.dogPictures.rvAdapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ismailgungor.dogPictures.dogsActivity.DogsActivityPresenter
import com.ismailgungor.dogPictures.dogsActivity.R
import com.ismailgungor.dogPictures.model.DogMainModel
import com.ismailgungor.dogPictures.viewHolder.SingleDogViewHolder

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogListAdapter(context: Context, dogList: ArrayList<DogMainModel>, presenter: DogsActivityPresenter) : RecyclerView.Adapter<SingleDogViewHolder>() {

    private var mContext: Context
    private var mDogList: ArrayList<DogMainModel>
    private var mPresenter: DogsActivityPresenter
    private var currentHolderView: SingleDogViewHolder? = null


    init {

        this.mContext = context
        this.mDogList = dogList
        this.mPresenter = presenter

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SingleDogViewHolder {

        val view = LayoutInflater.from(mContext).inflate(R.layout.row_single_dog, parent, false)
        return SingleDogViewHolder(view, mContext)

    }

    override fun onBindViewHolder(holder: SingleDogViewHolder?, position: Int) {

        currentHolderView = holder
        val currentDog = mDogList.get(position)

        currentHolderView?.setDogName(currentDog.getName().toUpperCase())
        currentHolderView?.setDogImage(currentDog.getImageUrl())
        currentHolderView?.itemView?.setOnClickListener {

            mPresenter.goDogImageActivity(currentDog)

        }


    }

    override fun getItemCount(): Int {

        return mDogList.size
    }

}