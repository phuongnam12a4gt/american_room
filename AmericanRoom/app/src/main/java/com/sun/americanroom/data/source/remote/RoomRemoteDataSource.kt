package com.sun.americanroom.data.source.remote

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.KeyEntity

class RoomRemoteDataSource private constructor()
    : RoomDataSource.Remote {

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

    private object Holder {
        val INSTANCE = RoomRemoteDataSource()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}
