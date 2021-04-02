package com.sun.americanroom.data.model

data class RoomSearch(
    var id: Int?,
    var imgUrl: String?,
    var nameRoom: String?,
    var city: String?,
    var state: String?,
    var ratingBar: Double?,
    var reviews: Int?,
    var price: Int?
)

object RoomSearchEntry {
    const val ID = "id"
    const val PICTUREURL = "picture_url"
    const val NAME = "name"
    const val CITY = "city"
    const val STATE = "state"
    const val REVIEWS = "reviews_count"
    const val PRICE = "price"
}
