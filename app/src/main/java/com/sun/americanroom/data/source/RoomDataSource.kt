package com.sun.americanroom.data.source

import com.sun.americanroom.data.model.*
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

interface RoomDataSource {

    interface Local

    interface Remote {
        fun getCity(
            listener: OnFetchDataJsonListener<MutableList<City>>,
            state: String,
            numberOfCity: Int
        )

        fun getTopRoom(
            listener: OnFetchDataJsonListener<MutableList<TopRoom>>,
            state: String,
            city: String
        )

        fun getNewRoom(
            listener: OnFetchDataJsonListener<MutableList<NewRoom>>,
            state: String,
            city: String
        )

        fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>)

        fun getRoomDetail(
            listener: OnFetchDataJsonListener<Room>,
            state: String,
            id: Int
        )
    }
}
