package com.sun.americanroom.screen.explore

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository

class ExplorePresenter(
    private val repository: RoomRepository
) : ExploreContract.Presenter {

    private var view: ExploreContract.View? = null

    override fun getCityExplore(state: String) {
        repository.getCityExplore(object : OnFetchDataJsonListener<MutableList<City>> {
            override fun onSuccess(data: MutableList<City>) {
                view?.getCityOnSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state)
    }

    override fun getRoomExplore() {
        repository.getRoomExplore(object : OnFetchDataJsonListener<MutableList<RoomExplore>> {
            override fun onSuccess(data: MutableList<RoomExplore>) {
                view?.getRoomExploreSuccess(getDataDefaultSlider(data))
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

    fun getDataDefaultSlider(data: MutableList<RoomExplore>): MutableList<RoomExplore> {
        var list: MutableList<RoomExplore> = mutableListOf()
        list.add(data.get(0))
        list.add(data.get(1))
        list.add(data.get(2))
        return list
    }
}
