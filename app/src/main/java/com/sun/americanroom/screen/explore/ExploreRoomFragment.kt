package com.sun.americanroom.screen.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.RoomExplore
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.explore.adapter.CityExploreAdapter
import com.sun.americanroom.screen.explore.adapter.RoomExploreAdapter
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import com.sun.americanroom.utils.StateCode
import kotlinx.android.synthetic.main.fragment_explore_room.*

class ExploreRoomFragment : Fragment(),
    OnItemRecyclerViewClickListener<City>,
    ExploreContract.View {

    private val adapterCityExplore: CityExploreAdapter by lazy { CityExploreAdapter() }
    private val adapterRoomExplore: RoomExploreAdapter by lazy { RoomExploreAdapter() }
    private val explorePresenter: ExploreContract.Presenter by lazy {
        ExplorePresenter(
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
        return inflater.inflate(R.layout.fragment_explore_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        with(recyclerViewCity) {
            setHasFixedSize(true)
            adapter = this@ExploreRoomFragment.adapterCityExplore
        }
        adapterCityExplore.registerItemRecyclerViewClickListener(this)
        viewPagerSlider.adapter = adapterRoomExplore
    }

    private fun initData() {
        explorePresenter.run {
            setView(this@ExploreRoomFragment)
            getCityExplore(StateCode.CALIFORNIA)
            getRoomExplore()
        }
    }

    override fun onItemClickListener(item: City?) {}

    override fun getCityOnSuccess(exploreCity: MutableList<City>) {
        adapterCityExplore.updateData(exploreCity)
    }

    override fun onError(exception: Exception?) {}

    override fun getRoomExploreSuccess(exploreRoom: MutableList<RoomExplore>) {
        activity?.let {
            adapterRoomExplore.updateDataRoomExplore(it, exploreRoom)
        }
    }

    companion object {
        fun newInstance() = ExploreRoomFragment()
    }
}
