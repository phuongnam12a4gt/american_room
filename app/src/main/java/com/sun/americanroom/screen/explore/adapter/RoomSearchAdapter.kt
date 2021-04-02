package com.sun.americanroom.screen.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.item_room_search.view.*

class RoomSearchAdapter(
    private val onItemClick: (RoomSearch) -> Unit
) : RecyclerView.Adapter<RoomSearchAdapter.ViewHolder>() {

    private var listRoomSearch = mutableListOf<RoomSearch>()

    fun updateData(listRoom: MutableList<RoomSearch>) {
        listRoomSearch = listRoom
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_search, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listRoomSearch.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(listRoomSearch[position])
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        fun bindData(room: RoomSearch) {
            itemView.run {
                room.run {
                    ratingBar?.let {
                        ratingBarStarCount.rating = it.toFloat()
                    }
                    textViewNameRoomSearch.text = "${nameRoom}"
                    textViewReviewsCount.text = "${reviews} ${context.getString(R.string.reviews)}"
                    textViewPrice.text = "${context.getString(R.string.dolar)} ${price}"
                    imageViewRoomSearch.loadImage(imgUrl.toString())
                }
                setOnClickListener(this@ViewHolder)
            }
        }

        override fun onClick(v: View?) {
            onItemClick(listRoomSearch[adapterPosition])
        }
    }
}
