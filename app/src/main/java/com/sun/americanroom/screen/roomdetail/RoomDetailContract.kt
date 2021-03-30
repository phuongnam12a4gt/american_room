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
    }

    interface Presenter : BasePresenter<View> {
        fun getRoomDetail(state: String, id: Int)
        fun getListRelatedRoom(state: String, city: String)
        fun displayLocationInMap(context: Context, latitude: Float, longitude: Float)
    }
}
