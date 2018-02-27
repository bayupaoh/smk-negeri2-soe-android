package id.sch.smknn2soe.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import id.sch.smknn2soe.R
import id.sch.smknn2soe.base.ui.BaseFragment
import id.sch.smknn2soe.model.dummy.DummyDataHead
import id.sch.smknn2soe.model.dummy.DummyDataArticle
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

        var dataItem = DummyDataArticle()
        dataItem.title = "Test"
        dataItem.date = "12 januari 2017"
        dataItem.imageUrl = "http://setara-institute.org/wp-content/uploads/2017/09/1494013633778-Screen-Shot-2017-05-05-at-72946-PM-660x330.jpg"

        data.content?.add(dataItem)
        data.content?.add(dataItem)
        data.content?.add(dataItem)
        data.content?.add(dataItem)

        adapter?.add(data)
        adapter?.add(data)
        adapter?.add(data)
        adapter?.notifyDataSetChanged()
    }

}