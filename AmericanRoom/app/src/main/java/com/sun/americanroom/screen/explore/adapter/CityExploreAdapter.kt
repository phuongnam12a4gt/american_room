package com.sun.americanroom.screen.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_city_explore.view.*

class CityExploreAdapter : RecyclerView.Adapter<CityExploreAdapter.ViewHolder?>() {

    private val listCity: MutableList<City> = mutableListOf()
    private val listimage: MutableList<Int> = mutableListOf()
    private var onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>? = null

    init {
        listimage.add(R.drawable.ic_image_city_default_1)
        listimage.add(R.drawable.ic_image_city_default_2)
        listimage.add(R.drawable.ic_image_city_default_3)
        listimage.add(R.drawable.ic_image_city_default_4)
        listimage.add(R.drawable.ic_image_city_default_5)
        listimage.add(R.drawable.ic_image_city_default_6)
        listimage.add(R.drawable.ic_image_city_default_7)
        listimage.add(R.drawable.ic_image_city_default_8)
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>?
    ) {
        this.onItemRecyclerViewClickListener = onItemRecyclerViewClickListener
    }

    fun updateData(city: MutableList<City>) {
        city.let {
            this.listCity.clear()
            this.listCity.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityExploreAdapter.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_explore, parent, false)
        return ViewHolder(view, onItemRecyclerViewClickListener)
    }

    override fun getItemCount(): Int {
        if (listCity.size <= 8) return listCity.size
        else return 8
    }

    override fun onBindViewHolder(holder: CityExploreAdapter.ViewHolder, position: Int) {
        holder.bindViewData(listCity[position], listimage[position])
    }

    inner class ViewHolder(
        item: View,
        private var onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<City>?
    ) : RecyclerView.ViewHolder(item), View.OnClickListener {
        fun bindViewData(nameCity: City, idimage: Int) {
            itemView.nameCity.text = nameCity.name
            itemView.imageCityDefault.setImageResource(idimage)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemRecyclerViewClickListener?.onItemClickListener(listCity[adapterPosition])
        }
    }
}
