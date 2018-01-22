package com.ismailgungor.dogPictures.helper.preferencesHelper

/**
 * Created by ismailgungor on 20.01.2018.
 */
interface ISharedPreferencesManagement {

    fun setAsString(key: String, value: String)

    fun getAsString(key: String, defaultValue: String): String

    fun setAsInteger(key: String, value: Int)

    fun getAsInteger(key: String, defaultValue: Int): Int

    fun setAsBoolean(key: String, value: Boolean)

    fun getAsBoolean(key: String, defaultBoolean: Boolean): Boolean

    fun setAsLong(key: String, value: Long)

    fun getAsLong(key: String, defaultValue: Long): Long

    fun deleteData(key: String)

    fun deleteAllData()

}