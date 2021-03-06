package com.example.kotlin_adpter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tab_view: TabLayout
    lateinit var pager_view: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blinding()
        tab_view.addTab(tab_view.newTab().setText("Chat"))
        tab_view.addTab(tab_view.newTab().setText("Status"))
        tab_view.addTab(tab_view.newTab().setText("call"))

        var adapter = Fragment_Adpter(this, supportFragmentManager)
        pager_view.adapter = adapter

        pager_view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_view))
        tab_view.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                pager_view.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })


    }

    fun blinding() {
        tab_view = findViewById<TabLayout>(R.id.tab_view)
        pager_view = findViewById<ViewPager>(R.id.pager_view)

    }
}
