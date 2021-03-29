package com.sun.americanroom.data.model

data class RoomExplore(
    val id: Int = 0,
    val city: String = "",
    val pictureUrl: String = "",
    val price: Int = 0,
    val nativeCurrency: String = "",
    val name: String = "",
    val reviewCount: Int = 0,
    val starRating: Int = 0
)

object RoomExploreEntry {
    const val LIST = "list"
    const val ID = "id"
    const val CITY = "city"
    const val PICTURE_URL = "picture_url"
    const val PRICE = "price"
    const val NATIVE_CURRENCY = "native_currency"
    const val NAME = "name"
    const val REVIEWCOUNT = "reviews_count"
    const val STARRATING = "star_rating"
}
