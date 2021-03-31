package com.sun.americanroom.data.source.local

import android.content.Context
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.local.dao.RoomDao
import com.sun.americanroom.data.source.local.database.DatabaseHelper

class RoomLocalDataSource private constructor(
    private val roomDao: RoomDao
) : RoomDataSource.Local {

    override fun saveRoom(
        room: Room,
        listener: OnFetchDataLocalListener<Room>
    ) {
        roomDao.save(room, listener)
    }

    override fun deleteRoom(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Room>
    ) {
        roomDao.delete(state, idRoom, listener)
    }

    override fun getRoom(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Room>
    ) {
        roomDao.fetchRoom(state, idRoom, listener)
    }

    override fun getAllRoom(
        listener: OnFetchDataLocalListener<MutableList<Room>>
    ) {
        roomDao.fetchAllRooms(listener)
    }

    companion object {
        @Volatile
        private var instance: RoomLocalDataSource? = null

        fun getLocalData(context: Context): RoomLocalDataSource =
            instance ?: synchronized(this) {
                instance ?: RoomLocalDataSource(
                    RoomDao.getRoomDao(DatabaseHelper.getDatabaseHelper(context))
                ).also {
                    instance = it
                }
            }
    }
}
