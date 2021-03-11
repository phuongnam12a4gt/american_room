package com.sun.americanroom.data.source

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

interface RoomDataSource {

    interface Local

    interface Remote {

        fun getCity(
            listener: OnFetchDataJsonListener<MutableList<City>>,
            state: String
        )

        fun getCityExplore(
            listener: OnFetchDataJsonListener<MutableList<City>>,
            state: String
        )

        fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>)

        fun getRoomSearch(listener: OnFetchDataJsonListener<MutableList<RoomSearch>>)
    }
}
