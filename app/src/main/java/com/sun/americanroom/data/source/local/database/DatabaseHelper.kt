package com.sun.americanroom.data.source.local.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sun.americanroom.data.source.local.schema.RoomSchema

class DatabaseHelper private constructor(
    context: Context
) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    VERSION_DATABASE
) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(RoomSchema.ROOM_TABLE_CREATE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) = Unit

    companion object {
        private const val DATABASE_NAME = "american_room.db"
        private const val VERSION_DATABASE = 1

        @Volatile
        private var instance: DatabaseHelper? = null

        fun getDatabaseHelper(context: Context): DatabaseHelper =
            instance ?: synchronized(this) {
                instance ?: DatabaseHelper(context).also {
                    instance = it
                }
            }
    }
}
