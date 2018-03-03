package id.sch.smkn2soe.feature.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import id.sch.smkn2soe.feature.calendar.CalendarFragment
import id.sch.smkn2soe.feature.event.EventFragment
import id.sch.smkn2soe.feature.home.HomeFragment
import id.sch.smkn2soe.feature.news.NewsFragment
import id.sch.smkn2soe.feature.schoolinfo.SchoolInfoFragment

/**
 * Created by King Oil on 25/02/2018.
 */
class MainActivityPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm) {
    private var fragments = ArrayList<Fragment>()
    private var currentFragment: Fragment? = null

    init {
        fragments.clear()
        fragments.add(HomeFragment())
        fragments.add(NewsFragment())
        fragments.add(EventFragment())
        fragments.add(CalendarFragment())
        fragments.add(SchoolInfoFragment())
    }

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size
}