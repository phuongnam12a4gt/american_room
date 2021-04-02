package com.sun.americanroom.data.source

import com.sun.americanroom.data.model.*
import com.sun.americanroom.data.source.local.OnFetchDataLocalListener
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

interface RoomDataSource {

    interface Local {

        fun saveRoom(
            room: Room,
            listener: OnFetchDataLocalListener<Room>
        )

        fun deleteRoom(
            state: String,
            idRoom: Int,
            listener: OnFetchDataLocalListener<Int>
        )

        fun getRoom(
            state: String,
            idRoom: Int,
            listener: OnFetchDataLocalListener<Room>
        )

        fun getAllRoom(
            listener: OnFetchDataLocalListener<MutableList<Room>>
        )
    }

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

        fun getRoomExplore(
            listener: OnFetchDataJsonListener<MutableList<RoomExplore>>
        )

        fun getRoomDetail(
            listener: OnFetchDataJsonListener<Room>,
            state: String,
            id: Int
        )

        fun getRoomSearch(
            listener: OnFetchDataJsonListener<MutableList<RoomSearch>>,
            name:String
        )
    }
}
