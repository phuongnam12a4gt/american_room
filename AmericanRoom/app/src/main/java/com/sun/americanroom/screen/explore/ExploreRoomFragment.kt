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
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_explore_room.*

class ExploreRoomFragment : Fragment(),
    ExploreContract.View,
    OnItemRecyclerViewClickListener<City> {

    private val adapterCityExplore: CityExploreAdapter by lazy { CityExploreAdapter() }
    private val explorePresenter: ExploreContract.Presenter by lazy {
        ExplorePresenter(
            RoomRepository.getRepository(
                RoomLocalDataSource.instance,
                RoomRemoteDataSource.instance
            )
        )
    }
    private val adapterRoomExplore: RoomExploreAdapter by lazy { RoomExploreAdapter() }
    private val listRoomSliderExplore: MutableList<RoomExplore>? = null

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

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initView() {
        with(viewListCity)
        {
            setHasFixedSize(true)
            adapter = this@ExploreRoomFragment.adapterCityExplore
        }
        adapterCityExplore.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        explorePresenter.run {
            setView(this@ExploreRoomFragment)
            getCityExplore(Constant.DEFAULT_STATE)
            getRoomExplore()
        }
    }

    override fun getCityOnSuccess(exploreCitys: MutableList<City>) {
        adapterCityExplore.updateData(exploreCitys)
    }

    override fun onError(exception: Exception?) {

    }

    override fun onItemClickListener(item: City?) {

    }

    override fun getRoomExploreSuccess(exploreRoom: MutableList<RoomExplore>) {
        activity?.let {
            adapterRoomExplore.updateDataRoomExplore(it, exploreRoom)
        }
        viewSliderPager.adapter = adapterRoomExplore
        circle_indicator.setViewPager(viewSliderPager)
        adapterRoomExplore.registerDataSetObserver(circle_indicator.dataSetObserver)
    }

    companion object {
        fun newInstance() = ExploreRoomFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
