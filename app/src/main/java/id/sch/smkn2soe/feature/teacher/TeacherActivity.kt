package id.sch.smkn2soe.feature.teacher

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.feature.detail.DetailActivity
import id.sch.smkn2soe.model.dummy.DummyDataHeaderTeacher
import id.sch.smkn2soe.model.dummy.DummyDataTeacher
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : BaseActivity(), TeacherActivityView,TeacherActivityItemItemView.OnActionListener {
    override fun onClicked(view: TeacherActivityItemItemView?) {
        startActivity(DetailActivity.createIntent(this, 4, "https://api.androidhive.info/webview/index.html"))
    }

    private var presenter: TeacherActivityPresenter? = null
    var adapter: TeacherActivityHeaderAdapter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_teacher

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarTeacher)
        supportActionBar?.title = "Guru Dan Pegawai"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = TeacherActivityHeaderAdapter(this)
        adapter?.setActionListener(this)
        recTeacher.setUpAsList()
        recTeacher.adapter = adapter
        recTeacher.setPullRefreshEnabled(false)
        recTeacher.setLoadingMoreEnabled(false)

        initData()
    }

    private fun initData() {
        var item1 = DummyDataTeacher()
        item1.name = "Ayub S.P.Sanam,S.Pd."
        item1.imageUrl = "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10372543_10202366822511781_4194173209914461804_n.jpg?oh=92ef2f1758349ac2e1519dbe06dc7f6f&oe=5B08B9DD"

        var header1 = DummyDataHeaderTeacher()
        header1.job = "Kepala Sekolah"
        header1.content?.add(item1)

        var item2 = DummyDataTeacher()
        item2.name = "Zem Tanaem, S. Kom."
        item2.imageUrl = "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/23559810_1723689887675269_7593087677247606152_n.jpg?oh=012fc86d8e20c314da21cb90ef42145f&oe=5B4E7352"

        var item3 = DummyDataTeacher()
        item3.name = "Eduard E. Alle, S. Pd."
        item3.imageUrl = "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10439013_1063890673623038_5475447974893624200_n.jpg?oh=5a3ef8de189400e6717ccda17422929c&oe=5B0805DB"

        var header2 = DummyDataHeaderTeacher()
        header2.job = "Guru Teknik Komputer jaringan"
        header2.content?.add(item2)
        header2.content?.add(item3)
        header2.content?.add(item2)
        header2.content?.add(item3)
        header2.content?.add(item2)
        header2.content?.add(item3)

        adapter?.add(header1)
        adapter?.add(header2)
        adapter?.notifyDataSetChanged()
    }

    private fun setupPresenter() {
        presenter = TeacherActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, TeacherActivity::class.java)
        }
    }
}
