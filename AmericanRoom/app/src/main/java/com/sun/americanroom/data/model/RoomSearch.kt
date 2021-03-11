package com.sun.americanroom.data.model

data class RoomSearch(
    var imgUrl: String,
    var nameRoom: String,
    var city: String,
    var ratingBar:Double,
    var reviews: Int,
    var price: Int
)

object RoomSearchEntry {
    const val PICTUREURL = "picture_url"
    const val NAME = "name"
    const val CITY = "city"
    const val RATINGBAR = "star_rating"
    const val REVIEWS = "reviews_count"
    const val PRICE = "price"
    const val LIST = "list"
}
