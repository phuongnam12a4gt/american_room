package com.sun.americanroom.data.source.local.dao

import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.source.local.OnFetchDataLocalListener

interface IRoomDao {

    fun save(room: Room, listener: OnFetchDataLocalListener<Room>)

    fun delete(state: String, idRoom: Int, listener: OnFetchDataLocalListener<Room>)

    fun fetchRoom(state: String, idRoom: Int, listener: OnFetchDataLocalListener<Room>)

    fun fetchAllRooms(listener: OnFetchDataLocalListener<MutableList<Room>>)
}
