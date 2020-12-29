package com.example.dscuifinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view_pager
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity(){
    lateinit var viewPager : ViewPager
    lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.my_tab_layout)
        setAdapters()

        val button = findViewById<Button>(R.id.main_submit_button)
        button.setOnClickListener{
            val intent = Intent(this,SubmitActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setAdapters() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LeaderFragment(),"Learning Leaders")
        adapter.addFragment(SkillFragment(),"Skill IQ Leaders")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(view_pager)
    }

}