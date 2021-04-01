package com.sun.americanroom.screen.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.Room

class FavoriteAdapter(
    private var onItemClick: (Room) -> Unit
) : RecyclerView.Adapter<ItemFavoriteViewHolder>() {

    private val favoriteRooms = mutableListOf<Room>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_room , parent, false)
        return ItemFavoriteViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemFavoriteViewHolder, position: Int) {
        holder.bindDataToView(favoriteRooms[position])
    }

    override fun getItemCount() = favoriteRooms.size

    fun addData(favoriteRooms: MutableList<Room>) {
        favoriteRooms.let {
            this.favoriteRooms.clear()
            this.favoriteRooms.addAll(it)
            notifyDataSetChanged()
        }
    }
}
