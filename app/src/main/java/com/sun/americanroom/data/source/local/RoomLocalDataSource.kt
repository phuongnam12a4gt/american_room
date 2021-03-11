package com.sun.americanroom.data.source.local

import com.sun.americanroom.data.source.RoomDataSource

class RoomLocalDataSource private constructor()
    : RoomDataSource.Local {

    private object Holder {
        val INSTANCE = RoomLocalDataSource()
    }

    companion object {
        val instance: RoomLocalDataSource by lazy { Holder.INSTANCE }
    }
}
