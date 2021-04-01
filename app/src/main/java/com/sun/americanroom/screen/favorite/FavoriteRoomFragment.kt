package com.sun.americanroom.screen.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.favorite.adapter.FavoriteAdapter
import com.sun.americanroom.screen.roomdetail.RoomDetailFragment
import com.sun.americanroom.utils.addFragment
import kotlinx.android.synthetic.main.fragment_favorite_room.*
import java.lang.Exception

class FavoriteRoomFragment : Fragment(),
    FavoriteContract.View {

    private val favoriteAdapter by lazy {
        FavoriteAdapter {
            addFragment(
                RoomDetailFragment.getDetail(it.state, it.id),
                R.id.containerLayout
            )
        }
    }
    private val favoritePresenter by lazy {
        FavoritePresenter(
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
        return inflater.inflate(
            R.layout.fragment_favorite_room,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initRecyclerView()
        refreshData()
    }

    private fun initPresenter() {
        favoritePresenter.apply {
            setView(this@FavoriteRoomFragment)
            getFavoriteRoom()
        }
    }

    private fun initRecyclerView() {
        recyclerViewFavorite.adapter = favoriteAdapter
    }

    private fun refreshData() {
        swipeRefreshLayoutFavorite.setOnRefreshListener {
            initPresenter()
        }
    }

    override fun getFavoriteRoomOnSuccess(room: MutableList<Room>) {
        favoriteAdapter.addData(room)
        swipeRefreshLayoutFavorite.isRefreshing = false
    }

    override fun deleteRoomLocalOnSuccess() {
        favoritePresenter.getFavoriteRoom()
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(requireContext(), exception?.toString(), Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = FavoriteRoomFragment()
    }
}
