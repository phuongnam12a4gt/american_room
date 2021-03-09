package com.sun.americanroom.screen.top

import com.sun.americanroom.data.model.City
import com.sun.americanroom.utils.BasePresenter

interface TopContract {
    interface View : TopContract {
        fun getCityOnSuccess(topCitys: MutableList<City>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getCity(state: String) : MutableList<City>
        fun getCityFromPick(state: String) : MutableList<City>?
    }
}
