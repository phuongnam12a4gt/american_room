package com.sun.americanroom.screen.explore

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.utils.BasePresenter

interface ExploreContract {
    interface View {
        fun getCityOnSuccess(exploreCity: MutableList<City>)
        fun onError(exception: Exception?)
        fun getRoomExploreSuccess(exploreRoom: MutableList<RoomExplore>)
    }

    interface Presenter : BasePresenter<View> {
        fun getCityExplore(state: String)
        fun getRoomExplore()
    }
}
