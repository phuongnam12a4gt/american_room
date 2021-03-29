package com.sun.americanroom.screen.explore

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.StateCode

class ExplorePresenter(
    private val repository: RoomRepository
) : ExploreContract.Presenter {

    private var view: ExploreContract.View? = null

    override fun getCityExplore(state: String) {
        repository.getCity(object : OnFetchDataJsonListener<MutableList<City>> {
            override fun onSuccess(data: MutableList<City>) {
                view?.getCityOnSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state, Constant.NUMBER_CITY_DEFAULT)
    }

    override fun getRoomExplore() {
        repository.getRoomExplore(object : OnFetchDataJsonListener<MutableList<RoomExplore>> {
            override fun onSuccess(data: MutableList<RoomExplore>) {
                view?.getRoomExploreSuccess(data)
            }

            override fun onError(exception: java.lang.Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: ExploreContract.View?) {
        this.view = view
    }
}
