package com.sun.americanroom.screen.new.roomitem.adapterroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.NewRoom

class NewRoomAdapter(
    private var onItemClick: (NewRoom) -> Unit
) : RecyclerView.Adapter<ItemNewRoomViewHolder>() {

    private val newRoomList = mutableListOf<NewRoom>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ItemNewRoomViewHolder =
        ItemNewRoomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_new_room, parent, false
            ), onItemClick
        )

    override fun getItemCount() = newRoomList.size

    override fun onBindViewHolder(holder: ItemNewRoomViewHolder, position: Int) =
        holder.bindViewData(newRoomList[position])

    fun addData(newRooms: MutableList<NewRoom>) {
        newRooms?.let {
            newRoomList.clear()
            newRoomList.addAll(it)
            notifyDataSetChanged()
        }
    }
}
