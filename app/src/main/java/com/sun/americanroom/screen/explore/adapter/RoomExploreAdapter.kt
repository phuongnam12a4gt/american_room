package com.sun.americanroom.screen.explore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.sun.americanroom.R
import com.sun.americanroom.data.model.RoomExplore
import kotlinx.android.synthetic.main.item_room_slider_explore.view.*

class RoomExploreAdapter : PagerAdapter() {

    private var context: Context? = null
    private var listRoomExplore = mutableListOf<RoomExplore>()

    fun updateDataRoomExplore(context: Context, roomExplore: MutableList<RoomExplore>) {
        this.context = context
        listRoomExplore = roomExplore
        notifyDataSetChanged()
    }

    override fun getCount() = listRoomExplore.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context)
            .inflate(R.layout.item_room_slider_explore, container, false)
        context?.let {
            listRoomExplore.get(position)?.let {
                it.run {
                    view.apply {
                        Glide.with(context).load(pictureUrl).into(imageViewRoomExplore)
                        textViewNameRoomExplore.text = name
                        textViewCityRoomExplore.text = city
                        textViewReviewsCount.text =
                            "${starRating} (${reviewCount} reviews)"
                    }
                }
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
