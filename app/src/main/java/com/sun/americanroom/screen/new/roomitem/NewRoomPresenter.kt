package com.sun.americanroom.screen.new.roomitem

import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository
import java.lang.Exception

class NewRoomPresenter(
    private val repository: RoomRepository
) : NewRoomContract.Presenter {

    private var view: NewRoomContract.View? = null

    override fun getNewRoom(state: String, city: String) {
        repository.getNewRoom(object : OnFetchDataJsonListener<MutableList<NewRoom>> {
            override fun onSuccess(data: MutableList<NewRoom>) {
                view?.getNewRoomOnSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state, city)
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: NewRoomContract.View?) {
        this.view = view
    }
}
