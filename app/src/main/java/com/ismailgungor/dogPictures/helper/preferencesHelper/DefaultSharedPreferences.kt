package com.ismailgungor.dogPictures.helper.preferencesHelper

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DefaultSharedPreferences(context: Context) : ISharedPreferencesManagement {

    private var mDefaultData: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun setAsString(key: String, value: String) {
        val editor = this.mDefaultData.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun getAsString(key: String, defaultValue: String): String {
        return this.mDefaultData.getString(key, defaultValue)
    }

    override fun setAsInteger(key: String, value: Int) {
        val editor = this.mDefaultData.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    override fun getAsInteger(key: String, defaultValue: Int): Int {
        return this.mDefaultData.getInt(key, defaultValue)
    }

    override fun setAsBoolean(key: String, value: Boolean) {
        val editor = this.mDefaultData.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    override fun getAsBoolean(key: String, defaultBoolean: Boolean): Boolean {
        return this.mDefaultData.getBoolean(key, defaultBoolean)
    }

    override fun setAsLong(key: String, value: Long) {
        val editor = this.mDefaultData.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    override fun getAsLong(key: String, defaultValue: Long): Long {
        return this.mDefaultData.getLong(key, defaultValue)
    }

    override fun deleteData(key: String) {
        val editor = this.mDefaultData.edit()
        editor.remove(key)
        editor.apply()
    }

    override fun deleteAllData() {
        val editor = this.mDefaultData.edit()
        editor.clear()
        editor.apply()
    }
}