package com.sun.americanroom.utils

import com.sun.americanroom.BuildConfig

object Constant {
    const val BASE_URL = "https://mashvisor-api.p.rapidapi.com/"
    const val API_KEY = "&rapidapi-key="
    const val API_VALUE = BuildConfig.API_KEY
    const val JSON_KEY_CONTENT = "content"
    const val TREND_CITY = "trends/cities"
    const val STATE = "?state="
    const val PAGE_DEFAULT = "&page=1"
    const val DEFAULT_STATE = "CA"
    const val NUMBER_ITEM = "&items=5"
    const val NUMBER_ITEM_CITY_EXPLORE = "&items=8"
    const val NUMBER_PAGE_ROOM_EXPLORE = "&page=1"
    const val AIR_PROPERTY = "airbnb-property/"
    const val TOP_REVIEWS = "top-reviewed"
    const val CITY_ROOM_EXPLORE_SLIDE = "&city=Los%20Angeles"
    const val REVIEW_COUNT = "&reviews_count=30"
    const val ZIP_CODE="&zip_code=91342"
}

object StateCode {
    const val CALIFORNIA = "CA"
    const val GEORGIA = "GA"
    const val FLORIDA = "FL"
    const val WASHINGTON = "WA"
    const val MICHIGAN = "MI"
}

object StateName {
    const val CALIFORNIA = "California"
    const val GEORGIA = "Georgia"
    const val MICHIGAN = "Michigan"
    const val WASHINGTON = "Washington"
    const val FLORIDA = "Florida"
}

object KeyEntity {
    const val CITY = "city"
    const val ROOM = "room"
}
