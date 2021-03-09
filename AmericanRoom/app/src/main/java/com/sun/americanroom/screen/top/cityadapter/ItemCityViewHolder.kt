package com.sun.americanroom.screen.top.cityadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.data.model.City
import kotlinx.android.synthetic.main.item_top.view.*

class ItemCityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindViewData(city: City) = with(itemView) {
        textViewCityName.text = city.name
    }
}
