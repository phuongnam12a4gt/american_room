package com.sun.americanroom.screen.top

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.source.RoomDataSource
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.utils.StateCode
import com.sun.americanroom.utils.StateName
import java.lang.Exception

class TopPresenter (
    private val repository: RoomRepository
) : TopContract.Presenter {

    private var view: TopContract.View? = null

    override fun getCity(state: String, numberOfCity: Int): MutableList<City> {
        var listCity = mutableListOf<City>()
        repository.getCity(object : OnFetchDataJsonListener<MutableList<City>> {
            override fun onSuccess(data: MutableList<City>) {
                view?.getCityOnSuccess(data)
                listCity = data
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state, numberOfCity)
        return listCity
    }

    override fun getCityFromPick(state: String): MutableList<City>? =
        when (state) {
            StateName.CALIFORNIA -> {
                getCity(StateCode.CALIFORNIA, NUMBER_OF_CITY)
            }
            StateName.GEORGIA -> {
                getCity(StateCode.GEORGIA, NUMBER_OF_CITY)
            }
            StateName.MICHIGAN -> {
                getCity(StateCode.MICHIGAN, NUMBER_OF_CITY)

            }
            StateName.WASHINGTON -> {
                getCity(StateCode.WASHINGTON, NUMBER_OF_CITY)

            }
            StateName.FLORIDA -> {
                getCity(StateCode.FLORIDA, NUMBER_OF_CITY)
            }
            else -> null
        }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: TopContract.View?) {
        this.view = view
    }

    companion object {
        private const val NUMBER_OF_CITY = 5
    }
}
