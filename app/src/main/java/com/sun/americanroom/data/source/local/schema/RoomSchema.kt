package com.sun.americanroom.data.source.local.schema

object RoomSchema {

    const val ROOM_TABLE = "room"
    const val COLUMN_ID = "id"
    const val COLUMN_IMAGE = "image"
    const val COLUMN_RATING = "rating"
    const val COLUMN_STATE = "state"
    const val COLUMN_NAME = "name"
    const val COLUMN_REVIEWS_COUNT = "reviews_count"
    const val COLUMN_PRICE = "price"
    const val COLUMN_CITY = "city"
    const val COLUMN_ADDRESS = "address"
    const val COLUMN_PERSON = "person_capacity"
    const val COLUMN_BEDROOMS = "bedrooms"
    const val COLUMN_BATHROOMS = "bathrooms"
    const val COLUMN_BEDS = "beds"
    const val COLUMN_DESCRIPTION = "description"
    const val COLUMN_MAP_IMAGE_URL = "map_image_url"
    const val COLUMN_LAT = "latitude"
    const val COLUMN_LNG = "longitude"
    const val ROOM_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
        "$ROOM_TABLE(" +
        "$COLUMN_ID INTEGER PRIMARY KEY," +
        "$COLUMN_IMAGE TEXT," +
        "$COLUMN_RATING FLOAT," +
        "$COLUMN_STATE TEXT," +
        "$COLUMN_NAME TEXT," +
        "$COLUMN_REVIEWS_COUNT INTEGER," +
        "$COLUMN_PRICE TEXT," +
        "$COLUMN_CITY TEXT," +
        "$COLUMN_ADDRESS TEXT," +
        "$COLUMN_PERSON INTEGER," +
        "$COLUMN_BEDROOMS INTEGER," +
        "$COLUMN_BATHROOMS INTEGER," +
        "$COLUMN_BEDS INTEGER," +
        "$COLUMN_DESCRIPTION TEXT," +
        "$COLUMN_MAP_IMAGE_URL TEXT," +
        "$COLUMN_LAT FLOAT," +
        "$COLUMN_LNG FLOAT)"
}
