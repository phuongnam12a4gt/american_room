package com.sun.americanroom.screen.roomdetail

import android.content.Context
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.utils.BasePresenter

interface RoomDetailContract {

    interface View : RoomDetailContract {
        fun getRoomDetailOnSuccess(room: Room)
        fun getListRelatedRoomOnSuccess(relatedRoom: MutableList<TopRoom>)
        fun onError(exception: Exception?)
        fun fetchRoomLocalOnSuccess(roomLocal: Room)
        fun saveRoomLocalOnSuccess()
        fun deleteRoomLocalOnSuccess()
        fun onFail(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getRoomDetail(state: String, id: Int)
        fun getListRelatedRoom(state: String, city: String)
        fun displayLocationInMap(context: Context, latitude: Float, longitude: Float)
        fun getRoomLocal(state: String, idRoom: Int)
        fun saveRoomLocal(roomLocal: Room)
        fun deleteRoomLocal(state: String, idRoom: Int)
    }
}
