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
    const val TOP_REVIEW = "airbnb-property/top-reviewed"
    const val CONSTRAINT_TEXT = "%20"
    const val ITEM = "&items="
    const val NULL = "null"
    const val CITY = "&city="
    const val NEW_HOME = "airbnb-property/newly-listed"
    const val NUMBER_CITY_DEFAULT = 8
    const val ZIP_CODE = "&zip_code=91342"
    const val NUMBER_ROOM_SLIDER = 3
    const val PROPERTY = "airbnb-property/"
    const val FORMAT_LOCATION = "geo:%f,%f"
    const val LIST = "list"
    const val THUMBNAIL_URL = "thumbnail_url"
    const val MEDIUM_URL = "medium_url"
    const val STAR_RATING = "star_rating"
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
    const val TOP_ROOM = "top_room"
    const val NEW_ROOM = "new_room"
    const val TOP_ROOM_SLIDER="top_room_slider"
    const val ROOM_DETAIL = "room_detail"
}
