package com.sun.americanroom.screen.explore.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import kotlinx.android.synthetic.main.fragment_search_room.*
import androidx.appcompat.widget.SearchView
import com.sun.americanroom.screen.explore.adapter.CitySearchAdapter
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import com.sun.americanroom.utils.addFragment

class SearchRoomFragment : Fragment() {

    private val adapterCitySearch: CitySearchAdapter by lazy {
        CitySearchAdapter {
            onClickItemCity(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        handleEvents()
    }

    private fun initView() {
        with(recyclerViewCitySearch)
        {
            setHasFixedSize(true)
            adapter = this@SearchRoomFragment.adapterCitySearch
        }
    }

    fun onClickItemCity(value: String) {
        recyclerViewCitySearch.visibility = View.GONE
    }

    private fun handleEvents() {
        imageViewBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        searchViewRoom.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterCitySearch.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterCitySearch.filter.filter(newText)
                recyclerViewCitySearch.visibility = View.VISIBLE
                return true
            }
        })
    }

    companion object {
        fun newInstance() = SearchRoomFragment()
    }
}
