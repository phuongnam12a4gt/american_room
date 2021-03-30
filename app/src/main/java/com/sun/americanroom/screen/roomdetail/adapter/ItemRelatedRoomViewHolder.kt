package com.sun.americanroom.screen.roomdetail.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.item_related_room.view.*

class ItemRelatedRoomViewHolder(
    itemView: View,
    private val onItemClicked: (TopRoom) -> Unit
) : RecyclerView.ViewHolder(itemView)  {

    fun bindDataToView(topRoom: TopRoom) = with(itemView) {
        if (topRoom.rating.toString().equals(Constant.NULL)) {
            cardViewRating.isVisible = false
        } else {
            textViewRating.text = topRoom.rating.toString()
        }
        textViewRoomName.text = topRoom.name.toString()
        topRoom.image?.let { imageViewRelatedRoom.loadImage(it) }
        setOnClickListener {
            onItemClicked(topRoom)
        }
    }
}
