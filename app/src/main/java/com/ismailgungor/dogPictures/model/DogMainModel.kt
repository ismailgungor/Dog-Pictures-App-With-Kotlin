package com.ismailgungor.dogPictures.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogMainModel(name: String, imageUrl: String) : Parcelable {

    private var name: String
    private var imageUrl: String

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())


    init {
        this.name = name
        this.imageUrl = imageUrl
    }


    fun getName(): String {

        return this.name
    }

    fun setName(name: String) {

        this.name = name
    }


    fun getImageUrl(): String {

        return this.imageUrl
    }

    fun setImageUrl(imageUrl: String) {

        this.imageUrl = imageUrl
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogMainModel> {
        override fun createFromParcel(parcel: Parcel): DogMainModel {
            return DogMainModel(parcel)
        }

        override fun newArray(size: Int): Array<DogMainModel?> {
            return arrayOfNulls(size)
        }
    }
}