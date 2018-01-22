package com.ismailgungor.dogPictures.helper.callbackHelper

import com.google.gson.JsonObject
import com.ismailgungor.dogPictures.util.JsonKeys

/**
 * Created by ismailgungor on 20.01.2018.
 */
class DogApiCallbackHelper {

    fun getDogNamesFromJson(jsonObject: JsonObject): ArrayList<String> {

        val dogNames = ArrayList<String>()

        val jsonNamesArray = jsonObject.getAsJsonArray(JsonKeys.MESSAGE)

        for (i in 0 until jsonNamesArray.size()) {
            dogNames.add(jsonNamesArray.get(i).asString)
        }

        return dogNames
    }

    fun getDogImageUrlFromJson(jsonObject: JsonObject): String {

        return jsonObject.get(JsonKeys.MESSAGE).asString

    }

}