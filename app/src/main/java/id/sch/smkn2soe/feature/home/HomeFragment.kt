package id.sch.smkn2soe.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View.GONE
import android.view.View.VISIBLE
import com.facebook.shimmer.ShimmerFrameLayout
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseFragment
import id.sch.smkn2soe.model.dummy.DummyDataHead
import id.sch.smkn2soe.model.dummy.DummyDataArticle
import id.sch.smkn2soe.model.dummy.DummyDataEvent
import id.sch.smkn2soe.model.dummy.DummyDataCalendar
import id.sch.smkn2soe.feature.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment(), HomeContentItemView.OnActionListener {
    override fun onClicked(view: HomeContentItemView?) {
        if (view?.getData() is DummyDataArticle) {
            startActivity(activity?.let { DetailActivity.createIntent(it, 0, "https://api.androidhive.info/webview/index.html") })
        }else if (view?.getData() is DummyDataEvent) {
            startActivity(activity?.let { DetailActivity.createIntent(it, 1, "https://api.androidhive.info/webview/index.html") })
        }
    }

    private var adapter: HomeHeadAdapter? = null
    val SPLASH_TIME_OUT = 2000L

    override val resourceLayout: Int = R.layout.fragment_home

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun initData() {
        var data1 = DummyDataHead()
        data1.title = "Berita dan Artikel Terbaru"
        data1.position = 1

        var data2 = DummyDataHead()
        data2.title = "Acara Sekolah Terbaru"
        data2.position = 2

        var data3 = DummyDataHead()
        data3.title = "Kalender Akademik"
        data3.position = 3

        var dataItemaArticle = DummyDataArticle()
        dataItemaArticle.title = "SMK NEGERI 2 SOE SUKSES MENGADAKAN ACARA PENTAS SENI SISWA DI GOR NEKMESE"
        dataItemaArticle.date = "12 januari 2017"
        dataItemaArticle.imageUrl = "http://setara-institute.org/wp-content/uploads/2017/09/1494013633778-Screen-Shot-2017-05-05-at-72946-PM-660x330.jpg"

        var dataItemEvent = DummyDataEvent()
        dataItemEvent.title = "PENTAS SENI SISWA"
        dataItemEvent.location = "GOR NEKMESE"
        dataItemEvent.date = "12 Januari 2017"
        dataItemEvent.imageUrl = "http://setara-institute.org/wp-content/uploads/2017/09/1494013633778-Screen-Shot-2017-05-05-at-72946-PM-660x330.jpg"

        var dataItemCalendar = DummyDataCalendar()
        dataItemCalendar.title = "Penerimaan Rapor dan Pengumuman Kelulusan"
        dataItemCalendar.date = "12"
        dataItemCalendar.month = "JAN"


        data1.content?.add(dataItemaArticle)
        data1.content?.add(dataItemaArticle)

        data2.content?.add(dataItemEvent)
        data2.content?.add(dataItemEvent)

        data3?.content?.add(dataItemCalendar)
        data3?.content?.add(dataItemCalendar)
        data3?.content?.add(dataItemCalendar)

        adapter?.add(data1)
        adapter?.add(data2)
        adapter?.add(data3)
        stopAnimationShimmer(shimmerHome)
        shimmerHome.visibility = GONE
        recHome.visibility = VISIBLE
        adapter?.notifyDataSetChanged()
    }

    private fun setupView() {
        imageHome.setImageURI("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/20728235_1576084712413168_4168956859642455220_n.jpg?oh=a9d528be39964e2c028cee24a459850c&oe=5B4E7EE3    ")

        adapter = HomeHeadAdapter(activity!!)
        adapter?.setActionListener(this)
        recHome.setUpAsList()

        recHome.adapter = adapter
        recHome.setPullRefreshEnabled(false)
        recHome.setLoadingMoreEnabled(false)

        recHome.visibility = GONE
        shimmerHome.visibility = VISIBLE
        startAnimationShimmer(shimmerHome)

        initData()
    }

    fun startAnimationShimmer(shimmerFrameLayout: ShimmerFrameLayout) {
        shimmerFrameLayout.startShimmerAnimation()
    }

    fun stopAnimationShimmer(shimmerFrameLayout: ShimmerFrameLayout) {
        shimmerFrameLayout.stopShimmerAnimation()
    }

}