package id.sch.smkn2soe.feature.awards

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.model.dummy.DummyDataAward
import id.sch.smkn2soe.model.dummy.DummyDataHeaderAward
import kotlinx.android.synthetic.main.activity_award.*

class AwardActivity : BaseActivity(), AwardActivityView {

    private var presenter: AwardActivityPresenter? = null
    var adapter: AwardActivityAdapter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_award

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarAward)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Prestasi"

        adapter = AwardActivityAdapter(this)
        recAward.setUpAsList()
        recAward.adapter = adapter
        recAward.setPullRefreshEnabled(false)
        recAward.setLoadingMoreEnabled(false)

        initData()
    }

    private fun initData() {
        var header = DummyDataHeaderAward()
        header.year = "2017"

        var item = DummyDataAward()
        item?.imageUrl = "http://fls2n.id/wp-content/uploads/fls2n2017-Vokal-pi-2.jpg"
        item?.title = "Juara 2 Nasional FL2SN "

        adapter?.add(header)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setupPresenter() {
        presenter = AwardActivityPresenter()
        presenter!!.attachView(this)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, AwardActivity::class.java)
        }
    }
}
