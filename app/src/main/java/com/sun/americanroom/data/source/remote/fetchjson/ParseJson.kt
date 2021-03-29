package com.sun.americanroom.data.source.remote.fetchjson

import com.sun.americanroom.data.model.*
import com.sun.americanroom.utils.Constant
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
                getString(Constant.THUMBNAIL_URL),
                if (getString(Constant.STAR_RATING).equals(Constant.NULL)) null
                else getDouble(Constant.STAR_RATING).toFloat(),
                getString(TopRoomEntry.NAME),
                getString(TopRoomEntry.STATE)
            )
        }

    fun parseJsonToNewRoom(jsonObject: JSONObject?): NewRoom? =
        jsonObject?.run {
            NewRoom(
                getInt(NewRoomEntry.ID),
                getString(Constant.THUMBNAIL_URL),
                if (getString(Constant.STAR_RATING).equals(Constant.NULL)) null
                else getDouble(Constant.STAR_RATING).toFloat(),
                getString(NewRoomEntry.NAME),
                getString(NewRoomEntry.STATE)
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

    fun parseJsonToRoomDetail(jsonObject: JSONObject?): Room? =
        jsonObject?.run {
            Room(
                getInt(RoomEntry.ID),
                getString(Constant.MEDIUM_URL),
                if (getString(Constant.STAR_RATING).equals(Constant.NULL)) null
                else getDouble(Constant.STAR_RATING).toFloat(),
                getString(RoomEntry.NAME),
                getString(RoomEntry.STATE),
                getString(RoomEntry.CITY),
                getString(RoomEntry.ADDRESS),
                getInt(RoomEntry.REVIEWS_COUNT),
                getString(RoomEntry.DESCRIPTION),
                getString(RoomEntry.PRICE),
                if (getString(RoomEntry.PERSON) == Constant.NULL) null
                else getInt(RoomEntry.PERSON),
                if (getString(RoomEntry.BEDROOMS) == Constant.NULL) null
                else getInt(RoomEntry.BEDROOMS),
                if (getString(RoomEntry.BEDS) == Constant.NULL) null
                else getInt(RoomEntry.BEDS),
                if (getString(RoomEntry.BATHROOMS) == Constant.NULL) null
                else getInt(RoomEntry.BATHROOMS),
                getString(RoomEntry.MAP_IMAGE_URL),
                getDouble(RoomEntry.LAT).toFloat(),
                getDouble(RoomEntry.LNG).toFloat()
            )
        }
}
