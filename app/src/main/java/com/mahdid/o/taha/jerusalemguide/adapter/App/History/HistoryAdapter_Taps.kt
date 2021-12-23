package com.mahdid.o.taha.jerusalemguide.adapter.App.History

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HistoryAdapter_Taps(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {
    private var fragmentList = ArrayList<Fragment>()
    private var fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
        notifyDataSetChanged()
    }
}
