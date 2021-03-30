package com.sun.americanroom.data.model

data class Room(
    val id: Int?,
    val image: String?,
    val rating: Float?,
    val name: String?,
    val state: String?,
    val city: String?,
    val address: String?,
    val reviewsCount: Int?,
    val description: String?,
    val price: String?,
    val person: Int?,
    val bedrooms: Int?,
    val bed: Int?,
    val bath: Int?,
    val locationImage: String?,
    val lat: Float?,
    val lng: Float?
)

object RoomEntry {
    const val ID = "id"
    const val STATE = "state"
    const val NAME = "name"
    const val REVIEWS_COUNT = "reviews_count"
    const val PRICE = "price_formatted"
    const val CITY = "city"
    const val ADDRESS = "address"
    const val PERSON = "person_capacity"
    const val BEDROOMS = "bedrooms"
    const val BATHROOMS = "bathrooms"
    const val BEDS = "beds"
    const val DESCRIPTION = "description"
    const val MAP_IMAGE_URL = "map_image_url"
    const val LAT = "lat"
    const val LNG = "lng"
}
