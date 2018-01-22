package com.ismailgungor.dogPictures.viewHolder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.ismailgungor.dogPictures.dogsActivity.R2
import com.squareup.picasso.Picasso

/**
 * Created by ismailgungor on 20.01.2018.
 */
class SingleDogViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

    private var mContext: Context

    @BindView(R2.id.tv_single_dog_name)
    lateinit var tvDogName: TextView

    @BindView(R2.id.iv_single_dog_image)
    lateinit var ivDogImage: ImageView


    init {
        this.mContext = context
        ButterKnife.bind(this, itemView)
    }


    fun setDogName(dogName: String) {

        this.tvDogName.setText(dogName)

    }

    fun setDogImage(url: String) {

        Picasso.with(mContext).load(url).error(R2.drawable.empty_iimage).into(ivDogImage)

    }


}