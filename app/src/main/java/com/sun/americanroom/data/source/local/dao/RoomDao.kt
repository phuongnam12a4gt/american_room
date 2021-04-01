package com.sun.americanroom.data.source.local.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteException
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.source.local.OnFetchDataLocalListener
import com.sun.americanroom.data.source.local.database.DatabaseHelper
import com.sun.americanroom.data.source.local.schema.RoomSchema

class RoomDao private constructor(
    private val databaseHelper: DatabaseHelper
) : IRoomDao {

    private var initialValues = ContentValues()

    override fun save(
        room: Room,
        listener: OnFetchDataLocalListener<Room>
    ) {
        setContentValues(room)
        try {
            databaseHelper.writableDatabase.insert(
                RoomSchema.ROOM_TABLE,
                null,
                initialValues
            ) > 0
            listener.onSuccess(room)
        } catch (ex: SQLiteException) {
            listener.onFail(ex)
        }
    }

    override fun delete(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Room>
    ) {
        databaseHelper.writableDatabase.delete(
            RoomSchema.ROOM_TABLE,
            "${RoomSchema.COLUMN_STATE}=? and ${RoomSchema.COLUMN_ID}=?",
            arrayOf(state, idRoom.toString())
        )
    }

    override fun fetchRoom(
        state: String,
        idRoom: Int,
        listener: OnFetchDataLocalListener<Room>
    ) {
        val cursor = databaseHelper.readableDatabase.query(
            RoomSchema.ROOM_TABLE,
            null,
            "${RoomSchema.COLUMN_STATE}=? and ${RoomSchema.COLUMN_ID}=?",
            arrayOf(state, idRoom.toString()),
            null,
            null,
            null
        )
        if (cursor != null) {
            while (!cursor.isAfterLast) {
                cursor.apply {
                    listener.onSuccess(cursorToEntity(this))
                    moveToNext()
                }
            }
            cursor.close()
        }
    }

    override fun fetchAllRooms(listener: OnFetchDataLocalListener<MutableList<Room>>) {
        val roomList = mutableListOf<Room>()
        val cursor = databaseHelper.readableDatabase.query(
            RoomSchema.ROOM_TABLE,
            null,
            null,
            null,
            null,
            null,
            null
        )
        if (cursor != null) {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                cursor.apply {
                    roomList.add(cursorToEntity(this))
                    moveToNext()
                }
            }
            cursor.close()
            listener.onSuccess(roomList)
        }
    }

    private fun setContentValues(room: Room) {
        initialValues = ContentValues().run {
            put(RoomSchema.COLUMN_ID, room.id)
            put(RoomSchema.COLUMN_IMAGE, room.image)
            put(RoomSchema.COLUMN_RATING, room.rating)
            put(RoomSchema.COLUMN_STATE, room.state)
            put(RoomSchema.COLUMN_NAME, room.name)
            put(RoomSchema.COLUMN_REVIEWS_COUNT, room.reviewsCount)
            put(RoomSchema.COLUMN_PRICE, room.price)
            put(RoomSchema.COLUMN_CITY, room.city)
            put(RoomSchema.COLUMN_ADDRESS, room.address)
            put(RoomSchema.COLUMN_PERSON, room.person)
            put(RoomSchema.COLUMN_BEDROOMS, room.bedrooms)
            put(RoomSchema.COLUMN_BATHROOMS, room.bath)
            put(RoomSchema.COLUMN_BEDS, room.bed)
            put(RoomSchema.COLUMN_DESCRIPTION, room.description)
            put(RoomSchema.COLUMN_MAP_IMAGE_URL, room.locationImage)
            put(RoomSchema.COLUMN_LAT, room.lat)
            put(RoomSchema.COLUMN_LNG, room.lng)
            this
        }
    }

    private fun cursorToEntity(cursor: Cursor) = with(cursor) {
        Room(
            id = getInt(getColumnIndex(RoomSchema.COLUMN_ID)),
            image = getString(getColumnIndex(RoomSchema.COLUMN_IMAGE)),
            rating = getFloat(getColumnIndex(RoomSchema.COLUMN_RATING)),
            state = getString(getColumnIndex(RoomSchema.COLUMN_STATE)),
            name = getString(getColumnIndex(RoomSchema.COLUMN_NAME)),
            reviewsCount = getInt(getColumnIndex(RoomSchema.COLUMN_REVIEWS_COUNT)),
            price = getString(getColumnIndex(RoomSchema.COLUMN_PRICE)),
            city = getString(getColumnIndex(RoomSchema.COLUMN_CITY)),
            address = getString(getColumnIndex(RoomSchema.COLUMN_ADDRESS)),
            person = getInt(getColumnIndex(RoomSchema.COLUMN_PERSON)),
            bedrooms = getInt(getColumnIndex(RoomSchema.COLUMN_BEDROOMS)),
            bath = getInt(getColumnIndex(RoomSchema.COLUMN_BATHROOMS)),
            bed = getInt(getColumnIndex(RoomSchema.COLUMN_BEDS)),
            description = getString(getColumnIndex(RoomSchema.COLUMN_DESCRIPTION)),
            locationImage = getString(getColumnIndex(RoomSchema.COLUMN_MAP_IMAGE_URL)),
            lat = getFloat(getColumnIndex(RoomSchema.COLUMN_LAT)),
            lng = getFloat(getColumnIndex(RoomSchema.COLUMN_LNG))
        )
    }

    companion object {
        @Volatile
        private var instance: RoomDao? = null

        fun getRoomDao(database: DatabaseHelper): RoomDao =
            instance ?: synchronized(this) {
                instance ?: RoomDao(database).also { instance = it }
            }
    }
}
