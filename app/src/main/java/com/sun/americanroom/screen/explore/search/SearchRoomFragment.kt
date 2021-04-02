package com.sun.americanroom.screen.explore.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import kotlinx.android.synthetic.main.fragment_search_room.*
import androidx.appcompat.widget.SearchView
import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.explore.adapter.CitySearchAdapter

class SearchRoomFragment : Fragment(),
    SearchRoomConstract.View {

    private val adapterCitySearch: CitySearchAdapter by lazy {
        CitySearchAdapter {
            onClickItemCity(it)
        }
    }
    private val searchRoomPresenter: SearchRoomConstract.Presenter by lazy {
        SearchRoomPresenter(
            RoomRepository.getRepository(
                RoomLocalDataSource.getLocalData(requireContext()),
                RoomRemoteDataSource.instance
            )
        )
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

    private fun initData(value: String) {
        searchRoomPresenter.run {
            setView(this@SearchRoomFragment)
            getRoomSearch(value)
        }
    }

    fun onClickItemCity(value: String) {
        recyclerViewCitySearch.visibility = View.GONE
        initData(value)
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
                if (newText.toString().isEmpty()) {
                    recyclerViewCitySearch.visibility = View.GONE
                }
                recyclerViewCitySearch.visibility = View.VISIBLE
                searchViewRoom.setBackgroundResource(R.drawable.custom_search)
                adapterCitySearch.filter.filter(newText)
                return true
            }
        })
    }

    override fun onSuccessRoomSearch(room: MutableList<RoomSearch>) {}

    override fun onError(exception: Exception?) {}

    companion object {
        fun newInstance() = SearchRoomFragment()
    }
}
