package com.sun.americanroom.screen.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.americanroom.R
import com.sun.americanroom.data.model.RoomSearch
import kotlinx.android.synthetic.main.item_search_room.view.*

class SearchAdapter() :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>(),
    Filterable {

    private var listRoomSearch: MutableList<RoomSearch> = mutableListOf()
    private var listRoomSearchOld: MutableList<RoomSearch> = mutableListOf()

    fun updataData(list: MutableList<RoomSearch>) {
        listRoomSearch = list
        listRoomSearchOld = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_room, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (listRoomSearch != null) {
            return listRoomSearch!!.size
        } else return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listRoomSearch[position])
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bindViewHolder(list: RoomSearch) {
            itemView.rating_bar.rating = list.ratingBar.toFloat()
            itemView.nameRoomSearch.text = list.nameRoom+"("+list.city+")"
            itemView.textReview.text = list.reviews.toString() + "(reviews)"
            itemView.price_room.text = "$" + list.price.toString()
            Glide.with(itemView.context).load(list.imgUrl).into(itemView.image_room_search)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var strSearch = constraint.toString()
                if (strSearch.isEmpty()) {
                    listRoomSearch = listRoomSearchOld
                } else {
                    var list: MutableList<RoomSearch> = mutableListOf()
                    for (i in listRoomSearchOld) {
                        if (i.city.toLowerCase().contains(strSearch.toLowerCase()))
                            list.add(i)
                    }
                    listRoomSearch = list
                }
                var filterResult = FilterResults()
                filterResult.values = listRoomSearch
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results != null) {
                    listRoomSearch = results.values as MutableList<RoomSearch>
                }
                notifyDataSetChanged()
            }
        }
    }
}
