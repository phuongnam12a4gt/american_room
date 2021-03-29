package com.sun.americanroom.screen.new

import com.sun.americanroom.data.model.City
import com.sun.americanroom.utils.BasePresenter

interface NewContract {

    interface View : NewContract {
        fun getCityOnSuccess(listCity: MutableList<City>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getCity(state: String, numberOfCity: Int) : MutableList<City>
        fun getCityFromPick(state: String) : MutableList<City>?
    }
}
