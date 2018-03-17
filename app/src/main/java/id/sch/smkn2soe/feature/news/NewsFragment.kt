package id.sch.smkn2soe.feature.news


import android.os.Bundle
import android.support.v4.app.Fragment

import id.sch.smkn2soe.R
import id.sch.smkn2soe.model.dummy.DummyDataArticle
import id.sch.smkn2soe.model.dummy.DummyDataHeaderArticle
import id.sch.smkn2soe.base.ui.BaseFragment
import id.sch.smkn2soe.feature.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : BaseFragment(),NewsItemView.OnActionListener {
    override fun onClicked(view: NewsItemView?) {
        startActivity(activity?.let { DetailActivity.createIntent(it,0,"https://api.androidhive.info/webview/index.html") })
    }

    var adapter: NewsAdapter? = null
    override val resourceLayout: Int = R.layout.fragment_news

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        adapter = activity?.let { NewsAdapter(it) }
        adapter?.setActionListener(this)
        recNews.setUpAsList()
        recNews.adapter = adapter
        recNews.setPullRefreshEnabled(false)
        recNews.setLoadingMoreEnabled(false)

        initData()
    }

    private fun initData() {
        var itemHeader = DummyDataHeaderArticle()
        itemHeader?.imageUrl = "https://scontent-sin6-2.xx.fbcdn.net/v/t1.0-9/13925253_1203033433051633_1279580852672065087_n.jpg?oh=26764faff3bb1abb19607a13eadb3e80&oe=5B130200"
        itemHeader?.title = "SMK Negeri 2 SoE terpilih menjadi sekolah teladan"
        itemHeader?.date = "12 Januari 2017"

        var item = DummyDataArticle()
        item?.imageUrl = "https://scontent-sin6-2.xx.fbcdn.net/v/t1.0-9/15541279_1455862074442246_1396944713567494313_n.jpg?oh=d5ad7257d33a06e632aba5e557a9cd5d&oe=5B4C2C84"
        item?.date = "12 Januari 2017"
        item?.title = "SMK Negeri 2 SoE sukses mengadakan acara pentas seni siswa"

        adapter?.add(itemHeader)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.add(item)
        adapter?.notifyDataSetChanged()
    }
}