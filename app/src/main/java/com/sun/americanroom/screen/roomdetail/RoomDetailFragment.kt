package com.sun.americanroom.screen.roomdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.sun.americanroom.R

class RoomDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_detail, container, false)
    }

    companion object {
        private const val ARG_STATE = "ARG_STATE"
        private const val ARG_ID = "ARG_ID"

        fun getDetail(state: String?, id: Int?) =
            RoomDetailFragment().apply {
                arguments = bundleOf(ARG_STATE to state, ARG_ID to id)
            }
    }
}
