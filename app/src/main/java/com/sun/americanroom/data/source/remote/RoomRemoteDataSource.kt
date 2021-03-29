package com.sun.americanroom.data.source.remote

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.KeyEntity
import com.sun.americanroom.utils.StateCode

class RoomRemoteDataSource private constructor() : RoomDataSource.Remote {

    override fun getCity(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String,
        numberOfCity: Int
    ) {
        val baseUrl = Constant.BASE_URL +
            Constant.TREND_CITY +
            Constant.STATE +
            state +
            Constant.PAGE_DEFAULT +
            Constant.ITEM +
            numberOfCity +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.CITY).execute(baseUrl)
    }

    override fun getTopRoom(
        listener: OnFetchDataJsonListener<MutableList<TopRoom>>,
        state: String,
        city: String
    ) {
        val baseUrl = Constant.BASE_URL +
            Constant.TOP_REVIEW +
            Constant.STATE +
            state +
            Constant.PAGE_DEFAULT +
            Constant.CITY +
            city.replace(" ", Constant.CONSTRAINT_TEXT) +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.TOP_ROOM).execute(baseUrl)
    }

    override fun getNewRoom(
        listener: OnFetchDataJsonListener<MutableList<NewRoom>>,
        state: String,
        city: String
    ) {
        val baseUrl = Constant.BASE_URL +
            Constant.NEW_HOME +
            Constant.STATE +
            state +
            Constant.CITY +
            city.replace(" ", Constant.CONSTRAINT_TEXT) +
            Constant.PAGE_DEFAULT
        GetJsonFromUrl(listener, KeyEntity.TOP_ROOM).execute(baseUrl)
    }

    override fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>) {
        val baseUrl = Constant.BASE_URL +
            Constant.TOP_REVIEW +
            Constant.STATE +
            StateCode.CALIFORNIA +
            Constant.PAGE_DEFAULT +
            Constant.ZIP_CODE +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.TOP_ROOM_SLIDER).execute(baseUrl)
    }

    private object Holder {
        val INSTANCE = RoomRemoteDataSource()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}
