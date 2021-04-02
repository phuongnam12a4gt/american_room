package com.sun.americanroom.data.source.repository

import com.sun.americanroom.data.model.*
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.local.OnFetchDataLocalListener
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

class RoomRepository private constructor(
    private val local: RoomDataSource.Local,
    private val remote: RoomDataSource.Remote
) {

    fun getCity(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String,
        numberOfCity: Int
    ) {
        remote.getCity(listener, state, numberOfCity)
    }

    fun getTopRoom(
        listener: OnFetchDataJsonListener<MutableList<TopRoom>>,
        state: String,
        city: String
    ) {
        remote.getTopRoom(listener, state, city)
    }

    fun getNewRoom(
        listener: OnFetchDataJsonListener<MutableList<NewRoom>>,
        state: String,
        city: String
    ) {
        remote.getNewRoom(listener, state, city)
    }

    fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>) {
        remote.getRoomExplore(listener)
    }

    fun getRoomDetail(
        listener: OnFetchDataJsonListener<Room>,
        state: String,
        id: Int
    ) {
        remote.getRoomDetail(listener, state, id)
    }

    fun saveRoom(
        room: Room,
        listener: OnFetchDataLocalListener<Room>
    ) {
        local.saveRoom(room, listener)
    }

    fun deleteRoom(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Int>
    ) {
        local.deleteRoom(state, idRoom, listener)
    }

    fun getRoom(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Room>
    ) {
        local.getRoom(state, idRoom, listener)
    }

    fun getAllRoom(
        listener: OnFetchDataLocalListener<MutableList<Room>>
    ) {
        local.getAllRoom(listener)
    }

    fun getRoomSearch(
        listener: OnFetchDataJsonListener<MutableList<RoomSearch>>,
        name: String
    ) {
        remote.getRoomSearch(listener, name)
    }

    companion object {
        @Volatile
        private var instance: RoomRepository? = null

        fun getRepository(
            local: RoomDataSource.Local,
            remote: RoomDataSource.Remote
        ): RoomRepository =
            instance ?: synchronized(this) {
                val newInstance =
                    instance ?: RoomRepository(local, remote).also { instance = it }
                newInstance
            }
    }
}
