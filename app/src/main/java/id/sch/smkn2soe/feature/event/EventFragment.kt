package id.sch.smkn2soe.feature.event


import android.os.Bundle
import android.support.v4.app.Fragment

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseFragment
import id.sch.smkn2soe.model.dummy.DummyDataEvent
import id.sch.smkn2soe.model.dummy.DummyDataHeaderEvent
import kotlinx.android.synthetic.main.fragment_event.*


/**
 * A simple [Fragment] subclass.
 */
class EventFragment : BaseFragment() {
    var adapter: EventAdapter? = null
    override val resourceLayout: Int = R.layout.fragment_event

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        adapter = EventAdapter(activity!!)
        recEvent.setUpAsList()
        recEvent.adapter = adapter
        recEvent.setPullRefreshEnabled(false)
        recEvent.setLoadingMoreEnabled(false)

        initData()
    }

    private fun initData() {
        val itemHeader= DummyDataHeaderEvent()
        itemHeader.imageUrl = "https://4.bp.blogspot.com/-plkKCyAG6qU/V8Z1P2A7OLI/AAAAAAAAAYM/NhRfJpvLDwwpvawfjF4DzFvxYyarA57MgCLcB/s1600/Wisata%2BBudaya%2BTarian%2BTebe.jpg"
        itemHeader.date = "12 Januari 2018 19:30"
        itemHeader.title = "Pentas Seni Tari Tradisional NTT"
        itemHeader.location = "Aula SMK Negeri 2 SoE"

        val item = DummyDataEvent()
        item.imageUrl = "http://cdn2.tstatic.net/bali/foto/bank/images/gerak-jalan-bangli_20150811_162829.jpg"
        item.date = "10 Januari 2018 15:00"
        item.title = "Lomba Gerak jalan antar SMA"
        item.location = "Kantor Bupati TTS"

        adapter?.add(itemHeader)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.notifyDataSetChanged()
    }

}