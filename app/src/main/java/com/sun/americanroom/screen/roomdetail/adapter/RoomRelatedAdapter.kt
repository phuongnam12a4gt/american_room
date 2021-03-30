package com.sun.americanroom.screen.roomdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.TopRoom

class RoomRelatedAdapter(
    private var onItemClick: (TopRoom) -> Unit
) : RecyclerView.Adapter<ItemRelatedRoomViewHolder>() {

    private val relatedRooms = mutableListOf<TopRoom>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemRelatedRoomViewHolder =
        ItemRelatedRoomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_related_room,
                    parent,
                    false
                ), onItemClick
        )

    override fun onBindViewHolder(
        holder: ItemRelatedRoomViewHolder,
        position: Int
    ) {
        holder.bindDataToView(relatedRooms[position])
    }

    fun addData(relatedRooms: MutableList<TopRoom>) {
        relatedRooms?.let {
            this.relatedRooms.clear()
            this.relatedRooms.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = relatedRooms.size
}
