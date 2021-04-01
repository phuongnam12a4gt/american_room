package com.sun.americanroom.screen.favorite

import com.sun.americanroom.data.model.Room
import com.sun.americanroom.utils.BasePresenter
import java.lang.Exception

interface FavoriteContract {

    interface View {
        fun getFavoriteRoomOnSuccess(room: MutableList<Room>)
        fun deleteRoomLocalOnSuccess()
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getFavoriteRoom()
        fun deleteRoom(state: String, idRoom: Int)
    }
}
