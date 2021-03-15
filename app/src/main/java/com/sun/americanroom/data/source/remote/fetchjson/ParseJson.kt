package com.sun.americanroom.data.source.remote.fetchjson

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.CityEntry
import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.NewRoomEntry
import com.sun.americanroom.utils.TopRoomEntry
import org.json.JSONObject

class ParseJson {

    fun parseJsonToCityFromTop(jsonObject: JSONObject?) =
        jsonObject?.run {
            City(
                getString(CityEntry.CITY),
                getString(CityEntry.STATE)
            )
        }

    fun parseJsonToTopRoom(jsonObject: JSONObject?): TopRoom? =
        jsonObject?.run {
            TopRoom(
                getInt(TopRoomEntry.ID),
                getString(TopRoomEntry.THUMBNAIL_URL),
                if (getString(TopRoomEntry.STAR_RATING).equals(Constant.NULL)) null
                else getDouble(TopRoomEntry.STAR_RATING).toFloat(),
                getString(TopRoomEntry.NAME),
                getString(TopRoomEntry.STATE)
            )
        }

    fun parseJsonToNewRoom(jsonObject: JSONObject?): NewRoom? =
        jsonObject?.run {
            NewRoom(
                getInt(NewRoomEntry.ID),
                getString(NewRoomEntry.THUMBNAIL_URL),
                if (getString(NewRoomEntry.STAR_RATING).equals(Constant.NULL)) null
                else getDouble(NewRoomEntry.STAR_RATING).toFloat(),
                getString(NewRoomEntry.NAME),
                getString(NewRoomEntry.STATE)
            )
        }
}
