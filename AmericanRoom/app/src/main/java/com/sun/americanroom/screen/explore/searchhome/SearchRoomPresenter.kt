package com.sun.americanroom.screen.explore.searchhome

import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository

class SearchRoomPresenter(
    private val repository: RoomRepository
) : SearchRoomConstract.Presenter {

    private var view: SearchRoomConstract.View? = null
    override fun getRoomSearch() {
        repository.getRoomSearch(object : OnFetchDataJsonListener<MutableList<RoomSearch>> {
            override fun onSuccess(data: MutableList<RoomSearch>) {
                view?.onSuccessRoomSearch(data)
            }

            override fun onError(exception: Exception?) {
                view?.onErr(exception)
            }
        }
        )
    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun setView(view: SearchRoomConstract.View?) {
        this.view = view
    }

}