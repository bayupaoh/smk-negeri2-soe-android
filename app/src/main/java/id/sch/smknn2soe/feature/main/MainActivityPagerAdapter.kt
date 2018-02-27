package id.sch.smknn2soe.feature.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import id.sch.smknn2soe.feature.home.HomeFragment

/**
 * Created by King Oil on 25/02/2018.
 */
class MainActivityPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm) {
    private var fragments = ArrayList<Fragment>()
    private var currentFragment: Fragment? = null

    init {
        fragments.clear()
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
    }

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size
}