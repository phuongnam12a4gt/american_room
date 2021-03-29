package com.sun.americanroom.screen.new.roomitem.adapterroom

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.item_new_room.view.*

class ItemNewRoomViewHolder(
    itemTopRoomView: View
) : RecyclerView.ViewHolder(itemTopRoomView) {

    fun bindViewData(newRoom: NewRoom) {
        itemView.apply {
            if (newRoom.rating.toString().equals(Constant.NULL)) {
                cardViewRating.isVisible = false
            } else {
                textViewRating.text = newRoom.rating.toString()
            }
            textViewRoomName.text = newRoom.name.toString()
            newRoom.image?.let { imageViewNewRoom.loadImage(it) }
        }
    }
}
