package com.sun.americanroom.data.source.repository

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

class RoomRepository private constructor(
    private val local: RoomDataSource.Local,
    private val remote: RoomDataSource.Remote
) {

    fun getCity(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String
    ) {
        remote.getCity(listener, state)
    }

    fun getCityExplore(
        listener: OnFetchDataJsonListener<MutableList<City>>,
        state: String
    ) {
        remote.getCityExplore(listener, state)
    }

    fun getRoomExplore(listener: OnFetchDataJsonListener<MutableList<RoomExplore>>) {
        remote.getRoomExplore(listener)
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
