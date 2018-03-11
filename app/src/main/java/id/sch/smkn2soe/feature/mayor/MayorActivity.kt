package id.sch.smkn2soe.feature.mayor

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.model.dummy.DummyDataMayor
import kotlinx.android.synthetic.main.activity_mayor.*

class MayorActivity : BaseActivity(), MayorActivityView {

    var adapter: MayorActivityAdapter? = null
    private var presenter: MayorActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_mayor

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarMayor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Jurusan"

        adapter = MayorActivityAdapter(this)
        recMayor.setUpAsList()
        recMayor.adapter = adapter
        recMayor.setPullRefreshEnabled(false)
        recMayor.setLoadingMoreEnabled(false)

        initData()
    }

    private fun initData() {
        var item1 = DummyDataMayor()
        item1?.imageUrl = "http://www.lonestar.edu/departments/webservices/program_cisco.jpg"
        item1?.title = "TEKNIK KOMPUTER DAN JARINGAN"

        var item2 = DummyDataMayor()
        item2?.imageUrl = "http://www.socialworker.com/downloads/1209/download/boardmeeting600.jpg?cb=800d8876498acffe0aa440534becc9b3&w=600&h="
        item2?.title = "PEKERJA SOSIAL"

        var item3 = DummyDataMayor()
        item3?.imageUrl = "http://www.lisaadelhi.com/wp-content/uploads/2016/08/fashion-designing-career.jpg"
        item3?.title = "TATA BUSANA"

        var item4 = DummyDataMayor()
        item4?.imageUrl = "https://3.bp.blogspot.com/-bGVUv2fJoCI/WWJyCbmhW0I/AAAAAAAAVNY/DGFSpBiedWcArIv8FdXjpjYEOLzRKNcaQCLcBGAs/s1600/keunggulan-jurusan-administrasi-perkantoran-di-smk-dan-universitas.jpg"
        item4?.title = "ADMINISTRASI PERKANTORAN"

        var item5 = DummyDataMayor()
        item5?.imageUrl = "http://1.bp.blogspot.com/-TCbzR-JxFr0/Te-b1-dUuYI/AAAAAAAAABI/AAfazE-4D9I/s1600/Front-Office.28571839_std.jpg"
        item5?.title = "AKOMODASI PERHOTELAN"

        adapter?.add(item1)
        adapter?.add(item2)
        adapter?.add(item3)
        adapter?.add(item4)
        adapter?.add(item5)
        adapter?.notifyDataSetChanged()
    }

    private fun setupPresenter() {
        presenter = MayorActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, MayorActivity::class.java)
        }
    }
}
