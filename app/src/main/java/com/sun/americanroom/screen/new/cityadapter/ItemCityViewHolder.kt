package com.sun.americanroom.screen.new.cityadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.new.roomitem.NewRoomContract
import com.sun.americanroom.screen.new.roomitem.NewRoomPresenter
import com.sun.americanroom.screen.new.roomitem.adapterroom.NewRoomAdapter
import kotlinx.android.synthetic.main.item_new.view.*

class ItemCityViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), NewRoomContract.View {

    private val adapterNewRoom by lazy { NewRoomAdapter() }
    private val presenterItemViewHolder: NewRoomContract.Presenter by lazy {
        NewRoomPresenter(
            RoomRepository.getRepository(
                RoomLocalDataSource.instance,
                RoomRemoteDataSource.instance
            )
        )
    }

    init {
        presenterItemViewHolder.setView(this)
        with(itemView) {
            recyclerViewItemNew.apply {
                setHasFixedSize(true)
                adapter = adapterNewRoom
            }
        }
    }

    override fun getNewRoomOnSuccess(newRoom: MutableList<NewRoom>) {
        adapterNewRoom.addData(newRoom)
    }

    override fun onError(exception: Exception?) {
        exception?.printStackTrace()
    }

    fun bindViewData(city: City) = with(itemView) {
        textViewCityNameNew.text = city.name
        presenterItemViewHolder.getNewRoom(city.state, city.name)
    }
}
