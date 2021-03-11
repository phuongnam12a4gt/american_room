package com.sun.americanroom.screen.explore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.sun.americanroom.R
import com.sun.americanroom.data.model.RoomExplore

class RoomExploreAdapter() : PagerAdapter() {

    private var context: Context? = null
    private var listRoomExplore: MutableList<RoomExplore>? = null

    fun updateDataRoomExplore(context: Context, roomExplore: MutableList<RoomExplore>) {
        this.context = context
        this.listRoomExplore = roomExplore
    }

    override fun getCount(): Int {
        if (listRoomExplore != null) return listRoomExplore!!.size
        else return 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context)
            .inflate(R.layout.item_room_slider_explore, container, false)
        var roomSliderExplore = listRoomExplore?.get(position)
        var imgview = view.findViewById(R.id.imgRoomExplore) as ImageView
        var name = view.findViewById(R.id.nameRoomExplore) as TextView
        var city = view.findViewById(R.id.cityRoomExplore) as TextView
        var star_count_review = view.findViewById(R.id.reviewsCountRoomExplore) as TextView
        if (roomSliderExplore != null && context != null) {

            Glide.with(context!!).load(roomSliderExplore.pictureUrl).into(imgview)
            name.text = roomSliderExplore.name
            city.text = roomSliderExplore.city
            star_count_review.text =
                roomSliderExplore.starRating.toString() + " (" + roomSliderExplore.reviewCount.toString() + " reviews)"
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
