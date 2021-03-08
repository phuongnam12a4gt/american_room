package com.sun.americanroom.data.source.remote.fetchjson

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.CityEntry
import org.json.JSONObject

class ParseJson {

    fun parseJsonToCityFromTop(jsonObject: JSONObject?) =
        jsonObject?.run {
            City(
                getString(CityEntry.CITY),
                getString(CityEntry.STATE)
            )
        }
}
