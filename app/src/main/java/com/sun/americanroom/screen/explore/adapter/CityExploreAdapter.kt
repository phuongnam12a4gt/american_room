package com.sun.americanroom.screen.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_city_explore.view.*

class CityExploreAdapter : RecyclerView.Adapter<CityExploreAdapter.ViewHolder?>() {

    private val listCity: MutableList<City> = mutableListOf()
    private val listimage: MutableList<Int> =
        mutableListOf(
            R.drawable.ic_image_city_default_1,
            R.drawable.ic_image_city_default_2,
            R.drawable.ic_image_city_default_3,
            R.drawable.ic_image_city_default_4,
            R.drawable.ic_image_city_default_5,
            R.drawable.ic_image_city_default_6,
            R.drawable.ic_image_city_default_7,
            R.drawable.ic_image_city_default_8
        )
    private var onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>? = null

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>?
    ) {
        this.onItemRecyclerViewClickListener = onItemRecyclerViewClickListener
    }

    fun updateData(city: MutableList<City>) {
        this.listCity.clear()
        this.listCity.addAll(city)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityExploreAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_explore, parent, false)
        return ViewHolder(view, onItemRecyclerViewClickListener)
    }

    override fun getItemCount() =
        if (listCity.size <= Constant.NUMBER_CITY_DEFAULT) listCity.size else Constant.NUMBER_CITY_DEFAULT

    override fun onBindViewHolder(holder: CityExploreAdapter.ViewHolder, position: Int) {
        holder.bindViewData(listCity[position], listimage[position])
    }

    inner class ViewHolder(
        item: View,
        private var onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>?
    ) : RecyclerView.ViewHolder(item), View.OnClickListener {
        fun bindViewData(nameCity: City, idImage: Int) {
            itemView.nameCity.text = nameCity.name
            itemView.imageCityDefault.setImageResource(idImage)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemRecyclerViewClickListener?.onItemClickListener(listCity[adapterPosition])
        }
    }
}
