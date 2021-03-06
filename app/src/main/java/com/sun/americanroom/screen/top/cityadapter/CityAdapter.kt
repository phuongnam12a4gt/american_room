package com.sun.americanroom.screen.top.cityadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.TopRoom

class CityAdapter(
    private var onItemClick: (TopRoom) -> Unit
) : RecyclerView.Adapter<ItemCityViewHolder>() {

    private val listCity = mutableListOf<City>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCityViewHolder =
        ItemCityViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_top, parent, false
                ), onItemClick
        )

    override fun getItemCount() = listCity.size

    override fun onBindViewHolder(holder: ItemCityViewHolder, position: Int) {
        holder.bindViewData(listCity[position])
    }

    fun addData(listCity: MutableList<City>) {
        listCity?.let {
            this.listCity.clear()
            this.listCity.addAll(it)
            notifyDataSetChanged()
        }
    }
}
