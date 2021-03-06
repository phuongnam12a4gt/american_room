package com.sun.americanroom.screen.main.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.american_room.screen.utils.MenuItem
import com.sun.americanroom.R
import com.sun.americanroom.screen.explore.ExploreRoomFragment
import com.sun.americanroom.screen.favorite.FavoriteRoomFragment
import com.sun.americanroom.screen.new.NewsRoomFragment
import com.sun.americanroom.screen.top.TopRoomFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : Fragment() {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListFragment()
        fragmentManager?.let {
            viewPagerContainer.adapter = ViewPagerContainerAdapter(it, fragments)
            initItemBottomBar()
        }
    }

    private fun initListFragment() {
        fragments.apply {
            add(MenuItem.EXPLORE.ordinal, ExploreRoomFragment.newInstance())
            add(MenuItem.TOP.ordinal, TopRoomFragment.newInstance())
            add(MenuItem.NEW.ordinal, NewsRoomFragment.newInstance())
            add(MenuItem.FAVORITE.ordinal, FavoriteRoomFragment.newInstance())
        }
    }

    private fun initItemBottomBar() {
        textViewTitle.text = getText(R.string.explore)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemExplore -> {
                    viewPagerContainer.currentItem = MenuItem.EXPLORE.ordinal
                    textViewTitle.text = getText(R.string.explore)
                    true
                }
                R.id.itemTop -> {
                    viewPagerContainer.currentItem = MenuItem.TOP.ordinal
                    textViewTitle.text = getText(R.string.top)
                    true
                }
                R.id.itemNew -> {
                    viewPagerContainer.currentItem = MenuItem.NEW.ordinal
                    textViewTitle.text = getText(R.string.news)
                    true
                }
                R.id.itemFavorite -> {
                    viewPagerContainer.currentItem = MenuItem.FAVORITE.ordinal
                    textViewTitle.text = getText(R.string.favorite)
                    true
                }
                else -> false
            }
        }
        viewPagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) = Unit
        })
    }

    companion object {
        fun newInstance() = HomePageFragment()
    }
}
