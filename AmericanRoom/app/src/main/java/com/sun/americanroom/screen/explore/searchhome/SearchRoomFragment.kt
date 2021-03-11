package com.sun.americanroom.screen.explore.searchhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.RoomSearch
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.explore.adapter.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search_room.*

class SearchRoomFragment : Fragment(), SearchRoomConstract.View {

    private val searchadapter: SearchAdapter by lazy { SearchAdapter() }
    private val SearchRoomPresenter: SearchRoomConstract.Presenter by lazy {
        SearchRoomPresenter(
            RoomRepository.getRepository(
                RoomLocalDataSource.instance,
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
        initData()
        handleEvents()
    }

    private fun handleEvents() {
        imageSearchBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    override fun onResume() {
        super.onResume()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchadapter?.filter?.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchadapter?.filter?.filter(newText)
                return false
            }
        }
        )
    }

    private fun initView() {
        with(recyclerviewListRoomCity)
        {
            setHasFixedSize(true)
            adapter = this@SearchRoomFragment.searchadapter
        }
    }

    private fun initData() {
        SearchRoomPresenter.run {
            setView(this@SearchRoomFragment)
            this.getRoomSearch()
        }
    }

    override fun onSuccessRoomSearch(room: MutableList<RoomSearch>) {
        searchadapter.updataData(room)
    }

    override fun onErr(exception: Exception?) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance() = SearchRoomFragment()
    }

}
