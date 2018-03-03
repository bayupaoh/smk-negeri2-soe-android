package id.sch.smkn2soe.feature.calendar


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseFragment
import id.sch.smkn2soe.model.dummy.DummyDataHeaderCalendar
import id.sch.smkn2soe.model.dummy.DummyDataCalendar
import kotlinx.android.synthetic.main.fragment_calendark.*


/**
 * A simple [Fragment] subclass.
 */
class CalendarFragment : BaseFragment() {
    var adapter: CalendarAdapter? = null
    override val resourceLayout: Int = R.layout.fragment_calendark

    override fun onViewReady(savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        adapter = CalendarAdapter(activity!!)
        recCalendar.setUpAsList()
        recCalendar.adapter = adapter
        recCalendar.setLoadingMoreEnabled(false)
        recCalendar.setPullRefreshEnabled(false)

        initData()
    }

    private fun initData() {
        var header = DummyDataHeaderCalendar()
        header.month = "Maret"
        header.year = "2018"

        var item = DummyDataCalendar()
        item.title = "Penerimaan Rapor Tahun Ajaran 2016"
        item.date = "17"
        item.day = "SAT"

        adapter?.add(header)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)

        var header1 = DummyDataHeaderCalendar()
        header1.month = "April"
        header1.year = "2018"
        adapter?.add(header1)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)

        adapter?.notifyDataSetChanged()
    }
}