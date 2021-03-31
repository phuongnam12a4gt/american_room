package com.sun.americanroom.screen.explore.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.R
import com.sun.americanroom.utils.CityName
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_city_search.view.*

class CitySearchAdapter(
    private val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<CitySearchAdapter.ViewHolder>(),
    Filterable {

    private val citySuggest = CityName.values().toMutableList()
    private var listCitySearch = mutableListOf<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_search, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listCitySearch.size

    override fun onBindViewHolder(holder: CitySearchAdapter.ViewHolder, position: Int) {
        holder.bindViewData(listCitySearch.get(position))
    }

    inner class ViewHolder(
        item: View
    ) : RecyclerView.ViewHolder(item), View.OnClickListener {

        fun bindViewData(nameCity: String) {
            itemView.textViewNameCity.text = nameCity
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClick(listCitySearch[adapterPosition])
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val list = mutableListOf<String>()
                if (constraint.toString().isEmpty()) {
                    listCitySearch.clear()
                } else {
                    for (i in citySuggest) {
                        if (i.value.toLowerCase().contains(constraint.toString().toLowerCase()))
                            list.add(i.value)
                    }
                }
                return FilterResults().apply {
                    values = list
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.let {
                    listCitySearch = results.values as MutableList<String>
                    notifyDataSetChanged()
                }
            }
        }
    }
}
