package id.sch.smkn2soe.feature.extrakurikuler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.model.dummy.DummyDataExtraKurikuler
import kotlinx.android.synthetic.main.activity_extra_kurikuler.*
import kotlinx.android.synthetic.main.refreshable_list.view.*

class ExtraKurikulerActivity : BaseActivity(), ExtraKurikulerActivityView, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: ExtraKurikulerActivityPresenter? = null
    var adapter: ExtraKurikulerActivityAdapter? = null
    override val resourceLayout: Int
        get() = R.layout.activity_extra_kurikuler

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarExtraKurikuler)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Extra Kurikuler"

        adapter = ExtraKurikulerActivityAdapter(this)
        recExtraKurikuler.setAsGrid(2)
        recExtraKurikuler.setOnRefreshListener(this)
        recExtraKurikuler.recyclerView.adapter = adapter

        initData()
    }

    private fun initData() {
        var item = DummyDataExtraKurikuler()
        item.title = "Pramuka"
        item.imageUrl = "http://2.bp.blogspot.com/-_yG114mewUc/Us0IZx6554I/AAAAAAAAAl8/zriE69jmVa0/s1600/Pengertian+Pramuka+dan+Sejarah+Pramuka.jpg"

        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.notifyDataSetChanged()
    }

    private fun setupPresenter() {
        presenter = ExtraKurikulerActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onRefresh() {
        recExtraKurikuler.isRefreshing = false
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, ExtraKurikulerActivity::class.java)
        }
    }
}
