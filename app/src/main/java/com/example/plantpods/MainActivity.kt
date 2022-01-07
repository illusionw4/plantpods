package com.example.plantpods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.plantpods.Typesplant.Flowering
import com.example.plantpods.Typesplant.Medicinal
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewpagerr : ViewPager
    lateinit var tablay: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        viewpagerr = findViewById(R.id.viewpagerr)
        tablay = findViewById(R.id.tablay)


        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Flowering(), "Flowering Plants")
        adapter.addFragment(Medicinal(),"Medicinal Plants")
        viewpagerr.adapter = adapter
        tablay.setupWithViewPager(viewpagerr)

    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titlelist: MutableList<String> = ArrayList()

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        fun addFragment(fragment: Fragment, title: String){
            fragmentList.add(fragment)
            titlelist.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titlelist[position]
        }
    }
}