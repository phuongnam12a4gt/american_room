package com.sun.americanroom.data.source.remote

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.KeyEntity
import com.sun.americanroom.utils.StateCode

class RoomRemoteDataSource private constructor() : RoomDataSource.Remote {

    override fun getCity(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String
    ) {
        val baseUrl = Constant.BASE_URL +
            Constant.TREND_CITY +
            Constant.STATE +
            state +
            Constant.PAGE_DEFAULT +
            Constant.NUMBER_ITEM +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.CITY).execute(baseUrl)
    }

    override fun getCityExplore(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String
    ) {
        val baseUrl = Constant.BASE_URL +
            Constant.TREND_CITY +
            Constant.STATE +
            state +
            Constant.PAGE_DEFAULT +
            Constant.NUMBER_ITEM_CITY_EXPLORE +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.CITY).execute(baseUrl)
    }

    override fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>) {
        val baseUrl = Constant.BASE_URL +
            Constant.AIR_PROPERTY +
            Constant.TOP_REVIEWS +
            Constant.STATE +
            StateCode.CALIFORNIA +
            Constant.NUMBER_PAGE_ROOM_EXPLORE +
            Constant.CITY_ROOM_EXPLORE_SLIDE +
            Constant.REVIEW_COUNT +
            Constant.ZIP_CODE +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.ROOM).execute(baseUrl)
    }

    override fun getRoomSearch(listener: OnFetchDataJsonListener<MutableList<RoomSearch>>) {
        val baseUrl = Constant.BASE_URL +
            Constant.AIR_PROPERTY +
            Constant.TOP_REVIEWS +
            Constant.STATE +
            Constant.DEFAULT_STATE +
            Constant.ZIP_CODE +
            Constant.API_KEY +
            Constant.API_VALUE
        GetJsonFromUrl(listener, KeyEntity.ROOMSEARCH).execute(baseUrl)
    }

    private object Holder {
        val INSTANCE = RoomRemoteDataSource()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}
