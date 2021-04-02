package com.sun.americanroom.screen.favorite

import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.source.local.OnFetchDataLocalListener
import com.sun.americanroom.data.source.repository.RoomRepository
import java.lang.Exception

class FavoritePresenter(
    private val repository: RoomRepository
) : FavoriteContract.Presenter {

    private var view: FavoriteContract.View? = null

    override fun getFavoriteRoom() {
        repository.getAllRoom(object : OnFetchDataLocalListener<MutableList<Room>> {
            override fun onSuccess(data: MutableList<Room>) {
                view?.getFavoriteRoomOnSuccess(data)
            }

            override fun onFail(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun deleteRoom(state: String, idRoom: Int) {
        repository.deleteRoom(state, idRoom, object : OnFetchDataLocalListener<Int> {
            override fun onSuccess(data: Int) {
                view?.deleteRoomLocalOnSuccess()
            }

            override fun onFail(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: FavoriteContract.View?) {
        this.view = view
    }
}
