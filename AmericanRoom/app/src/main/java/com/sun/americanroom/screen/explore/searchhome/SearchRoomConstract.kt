package com.sun.americanroom.screen.explore.searchhome

import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.utils.BasePresenter

interface SearchRoomConstract {

    interface View {
        fun onSuccessRoomSearch(room: MutableList<RoomSearch>)
        fun onErr(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getRoomSearch()
    }

}