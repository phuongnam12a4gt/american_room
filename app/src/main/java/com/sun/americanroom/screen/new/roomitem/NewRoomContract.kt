package com.sun.americanroom.screen.new.roomitem

import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.utils.BasePresenter

interface NewRoomContract {

    interface View : NewRoomContract {
        fun getNewRoomOnSuccess(newRoom: MutableList<NewRoom>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getNewRoom(state: String, city: String)
    }
}
