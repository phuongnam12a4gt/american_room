package com.sun.americanroom.screen.favorite.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.item_favorite_room.view.*
import kotlinx.android.synthetic.main.item_favorite_room.view.textViewRating

class ItemFavoriteViewHolder(
    itemView: View,
    private val onItemClick: (Room) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bindDataToView(favoriteRoom: Room) = with(itemView) {
        favoriteRoom.image?.let { imageViewFavoriteRoom.loadImage(it) }
        textViewNameRoom.text = favoriteRoom.name
        if (favoriteRoom.rating == NUMBER_0_FLOAT) {
            textViewRating.isVisible = false
            imageViewStar.isVisible = false
        } else {
            textViewRating.text = favoriteRoom.rating.toString()
        }
        textViewCity.text = favoriteRoom.city
        textViewPrice.text = favoriteRoom.price
        setOnClickListener {
            onItemClick(favoriteRoom)
        }
    }

    companion object {
        private const val NUMBER_0_FLOAT = 0.0f
    }
}
