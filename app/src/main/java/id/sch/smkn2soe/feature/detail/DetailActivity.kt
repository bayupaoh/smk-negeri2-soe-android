package id.sch.smkn2soe.feature.detail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.webkit.*

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_article.*

class DetailActivity : BaseActivity(), DetailActivityView, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: DetailActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_detail_article

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        when (intent.getIntExtra(EXTRA_DETAIL_TYPE, 0)) {
            0 -> supportActionBar?.title = "Berita"
            1 -> supportActionBar?.title = "Acara"
            2 -> supportActionBar?.title = "Detail Jurusan"
            3 -> supportActionBar?.title = "Detail Prestasi"
            4 -> supportActionBar?.title = "Detail Guru"
            5 -> supportActionBar?.title = "Detail Ekstra Kurikuler"
        }

        srDetail.setOnRefreshListener(this)

        webViewDetail.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                if (url != null) {
                    if (!url.contains("api.androidhive.info", true)) {
                        webViewDetail.loadUrl(intent.getStringExtra(EXTRA_DETAIL_URL))
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }
                }

                srDetail.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                srDetail.isRefreshing = false
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
            }
        }

        webViewDetail.clearCache(true)
        webViewDetail.clearHistory()
        webViewDetail.getSettings().setJavaScriptEnabled(true)
        webViewDetail.setHorizontalScrollBarEnabled(false)
        webViewDetail.loadUrl(intent.getStringExtra(EXTRA_DETAIL_URL))
    }

    private fun setupPresenter() {
        presenter = DetailActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onRefresh() {
        webViewDetail.loadUrl(intent.getStringExtra(EXTRA_DETAIL_URL))
    }

    companion object {
        val EXTRA_DETAIL_TYPE = "EXTRA_DETAIL_TYPE"
        val EXTRA_DETAIL_URL = "EXTRA_DETAIL_URL"
        fun createIntent(context: Context, detailType: Int, url: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_DETAIL_TYPE, detailType)
            intent.putExtra(EXTRA_DETAIL_URL, url)
            return intent
        }
    }
}
