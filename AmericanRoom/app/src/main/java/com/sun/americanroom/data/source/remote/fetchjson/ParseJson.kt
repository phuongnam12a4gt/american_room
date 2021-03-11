package com.sun.americanroom.data.source.remote.fetchjson

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.CityEntry
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.model.RoomExploreEntry
import org.json.JSONObject

class ParseJson {

    fun parseJsonToCityFromTop(jsonObject: JSONObject?) =
        jsonObject?.run {
            City(
                getString(CityEntry.CITY),
                getString(CityEntry.STATE)
            )
        }

    fun parseJsonToRoomFromTop(jsonObject: JSONObject?) =
        jsonObject?.run {
            RoomExplore(
                getInt(RoomExploreEntry.ID),
                getString(RoomExploreEntry.CITY),
                getString(RoomExploreEntry.PICTURE_URL),
                getInt(RoomExploreEntry.PRICE),
                getString(RoomExploreEntry.NATIVE_CURRENCY),
                getString(RoomExploreEntry.NAME),
                getInt(RoomExploreEntry.REVIEWCOUNT),
                getInt(RoomExploreEntry.STARRATING)
            )
        }
}
