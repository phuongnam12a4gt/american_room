package com.sun.americanroom.screen.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.explore.adapter.CityExploreAdapter
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import com.sun.americanroom.utils.StateCode
import kotlinx.android.synthetic.main.fragment_explore_room.*

class ExploreRoomFragment : Fragment(),
    OnItemRecyclerViewClickListener<City> {

    private val adapterCityExplore: CityExploreAdapter by lazy { CityExploreAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(recyclerViewCity) {
            setHasFixedSize(true)
            adapter = this@ExploreRoomFragment.adapterCityExplore
        }
        adapterCityExplore.registerItemRecyclerViewClickListener(this)
    }

    override fun onItemClickListener(item: City?) {
    }

    companion object {
        fun newInstance() = ExploreRoomFragment()
    }
}
