package com.sun.americanroom.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.americanroom.R
import com.sun.americanroom.screen.main.page.HomePageFragment
import com.sun.americanroom.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomePageFragment.newInstance(), R.id.containerLayout)
    }
}
