package com.sun.americanroom.data.model

data class NewRoom(
    val id: Int?,
    val image: String?,
    val rating: Float?,
    val name: String?,
    val state: String?
)

object NewRoomEntry {
    const val ID = "id"
    const val NAME = "name"
    const val STATE = "state"
}
