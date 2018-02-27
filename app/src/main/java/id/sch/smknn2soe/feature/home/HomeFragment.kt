package id.sch.smknn2soe.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import id.sch.smknn2soe.R
import id.sch.smknn2soe.base.ui.BaseFragment
import id.sch.smknn2soe.model.dummy.DummyDataHead
import id.sch.smknn2soe.model.dummy.DummyDataArticle
import id.sch.smknn2soe.model.dummy.DummyDataEvent
import id.sch.smknn2soe.model.dummy.DummyDataCalendar
import id.sch.smknn2soe.helper.Shortcut
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    private var adapter: HomeHeadAdapter? = null

    override val resourceLayout: Int = R.layout.fragment_home

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        imageHome.setImageURI("http://static.republika.co.id/uploads/images/inpicture_slide/sma-muhammadiyah-1-yogyakarta-_140303173113-516.jpg")

        adapter = HomeHeadAdapter(activity!!)

        recHome.setUpAsList()

        recHome.adapter = adapter
        recHome.setPullRefreshEnabled(false)
        recHome.setLoadingMoreEnabled(false)

        var data = DummyDataHead()
        data.title = "Berita dan Artikel Terbaru"
        data.position = 1

        var data2 = DummyDataHead()
        data2.title = "Acara Sekolah Terbaru"
        data2.position = 2



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
        dataItemCalendar.title = "PENTAS SENI SISWA"
        dataItemCalendar.date = "12 Januari 2017"


        data.content?.add(dataItemaArticle)
        data.content?.add(dataItemaArticle)

        data2.content?.add(dataItemEvent)
        data2.content?.add(dataItemEvent)

        adapter?.add(data)
        adapter?.add(data2)
        adapter?.notifyDataSetChanged()
    }

}