package com.sun.americanroom.screen.new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.new.cityadapter.CityAdapter
import com.sun.americanroom.screen.roomdetail.RoomDetailFragment
import com.sun.americanroom.utils.StateName
import com.sun.americanroom.utils.addFragment
import kotlinx.android.synthetic.main.fragment_news_room.*

class NewsRoomFragment : Fragment(),
    AdapterView.OnItemSelectedListener,
    NewContract.View {

    private val cityAdapter by lazy {
        CityAdapter {
            addFragment(
                RoomDetailFragment.getDetail(it.state, it.id),
                R.id.containerLayout
            )
        }
    }
    private val newPresenter: NewContract.Presenter by lazy {
        NewPresenter(
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
        return inflater.inflate(R.layout.fragment_news_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSpinner(view)
        initPresenter()
    }

    private fun initRecyclerView() {
        recyclerViewNew.apply {
            setHasFixedSize(true)
            adapter = cityAdapter
        }
    }

    private fun initSpinner(view: View) {
        val listState = mutableListOf<String>(
            StateName.CALIFORNIA,
            StateName.GEORGIA,
            StateName.MICHIGAN,
            StateName.WASHINGTON,
            StateName.FLORIDA
        )
        val stateAdapter = ArrayAdapter<String>(
            view.context,
            R.layout.style_spinner,
            listState
        )
        spinnerPickAState.adapter = stateAdapter
        spinnerPickAState.onItemSelectedListener = this
    }

    private fun initPresenter() {
        newPresenter.setView(this)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int, id: Long
    ) {
        newPresenter.getCityFromPick(parent?.selectedItem.toString())?.let {
            getCityOnSuccess(
                it
            )
        }
    }

    override fun getCityOnSuccess(listCity: MutableList<City>) {
        cityAdapter.addData(listCity)
    }

    override fun onError(exception: Exception?) {
        exception?.printStackTrace()
    }

    companion object {
        fun newInstance() = NewsRoomFragment()
    }
}
