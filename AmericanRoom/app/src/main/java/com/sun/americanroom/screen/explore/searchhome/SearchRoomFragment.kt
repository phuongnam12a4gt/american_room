package com.sun.americanroom.screen.explore.searchhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.americanroom.R

class SearchRoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_room, container, false)
    }

    companion object {
        fun newInstance() = SearchRoomFragment()
    }
}
