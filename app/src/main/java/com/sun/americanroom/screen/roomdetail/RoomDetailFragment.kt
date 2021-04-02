package com.sun.americanroom.screen.roomdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.sun.americanroom.R
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.data.source.local.RoomLocalDataSource
import com.sun.americanroom.data.source.remote.RoomRemoteDataSource
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.screen.roomdetail.adapter.RoomRelatedAdapter
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.addFragment
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.fragment_room_detail.*
import java.util.*

class RoomDetailFragment : Fragment(), RoomDetailContract.View {

    private var state: String? = null
    private var id: Int? = null
    private var latitude: Float? = null
    private var longitude: Float? = null
    private var isCheck = false
    private var room: Room? = null
    private val relatedAdapter by lazy {
        RoomRelatedAdapter {
            addFragment(
                getDetail(it.state, it.id),
                R.id.containerLayout
            )
        }
    }

    private val roomDetailPresenter: RoomDetailContract.Presenter by lazy {
        RoomDetailPresenter(
            RoomRepository.getRepository(
                RoomLocalDataSource.getLocalData(requireContext()),
                RoomRemoteDataSource.instance
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            state = it.getString(ARG_STATE)
            id = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_room_detail,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initRecyclerView()
        backButtonClick()
        openMapClick()
        favoriteClick()
    }

    private fun initRecyclerView() {
        recyclerViewRelated.apply {
            setHasFixedSize(true)
            adapter = relatedAdapter
        }
    }

    private fun openMapClick() {
        buttonOpenMap.setOnClickListener {
            latitude?.let { dataLatitude ->
                longitude?.let { dataLongitude ->
                    roomDetailPresenter.displayLocationInMap(
                        requireContext(),
                        dataLatitude,
                        dataLongitude
                    )
                }
            }
        }
    }

    private fun backButtonClick() {
        imageViewBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun initPresenter() {
        roomDetailPresenter.apply {
            setView(this@RoomDetailFragment)
            state?.let {
                id?.let { idData ->
                    getRoomDetail(it, idData)
                    getRoomLocal(it, idData)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun getRoomDetailOnSuccess(room: Room) {
        room.apply {
            textViewRoomName.text = name
            textViewCity.text = city
            if (rating.toString() == Constant.NULL) {
                textViewRatingPoint.isVisible = false
                imageViewStar.isVisible = false
            } else {
                textViewRatingPoint.text = rating.toString()
            }
            if (reviewsCount == NUMBER_0) {
                textViewReviews.isVisible = false
            } else {
                textViewReviews.text = String.format(
                    getString(R.string.reviews_count),
                    reviewsCount
                )
            }
            textViewContent.text = description
            textViewPerson.text = person.toString()
            textViewBedrooms.text = bedrooms.toString()
            if (bed.toString() == Constant.NULL) {
                textViewBed.isVisible = false
            } else {
                textViewBed.text = bed.toString()
            }
            textViewBath.text = bath.toString()
            textViewPrice.text = price
            image?.let { imageViewRoom.loadImage(it) }
            locationImage?.let { imageViewLocation.loadImage(it) }
            latitude = lat
            longitude = lng
            state?.let {
                city?.let { cityData ->
                    roomDetailPresenter.getListRelatedRoom(it, cityData)
                }
            }
        }
        this.room = room
    }

    override fun getListRelatedRoomOnSuccess(
        relatedRoom: MutableList<TopRoom>
    ) {
        relatedAdapter.addData(relatedRoom)
    }

    override fun fetchRoomLocalOnSuccess(roomLocal: Room) {
        checkFavorite(true)
    }

    override fun saveRoomLocalOnSuccess() {
        checkFavorite(true)
    }

    override fun deleteRoomLocalOnSuccess() {
        checkFavorite(false)
    }

    override fun onFail(exception: Exception?) {
        checkFavorite(false)
    }

    private fun favoriteClick() {
        imageViewLike.setOnClickListener {
            if (isCheck) {
                state?.let { stateData ->
                    id?.let { idData ->
                        roomDetailPresenter.deleteRoomLocal(
                            stateData,
                            idData
                        )
                    }
                }
            } else {
                room?.let { roomData ->
                    roomDetailPresenter.saveRoomLocal(roomData)
                }
            }
        }
    }

    private fun checkFavorite(isFavorite: Boolean) {
        isCheck = isFavorite
        if (isFavorite)
            imageViewLike.setImageResource(R.drawable.ic_favorite_checked)
        else
            imageViewLike.setImageResource(R.drawable.ic_favourite)
    }

    override fun onError(exception: Exception?) {
        exception?.printStackTrace()
    }

    companion object {
        private const val ARG_STATE = "ARG_STATE"
        private const val ARG_ID = "ARG_ID"
        private const val NUMBER_0 = 0

        fun getDetail(state: String?, id: Int?) =
            RoomDetailFragment().apply {
                arguments = bundleOf(ARG_STATE to state, ARG_ID to id)
            }
    }
}
