package com.sun.americanroom.data.model

data class City(
    val name: String = "",
    val state: String = ""
)

object CityEntry {
    const val CITIES = "cities"
    const val CITY = "city"
    const val STATE = "state"
}
