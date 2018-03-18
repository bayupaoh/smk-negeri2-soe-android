package id.sch.smkn2soe.feature.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import id.sch.smkn2soe.BuildConfig

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : BaseActivity(), AboutActivityView {

    private var presenter: AboutActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_about

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarAbout)
        supportActionBar?.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        txtVersionAbout.text = "V "+BuildConfig.VERSION_NAME
        webViewAbout.getSettings().setJavaScriptEnabled(true)
        webViewAbout.setHorizontalScrollBarEnabled(false)
        webViewAbout.loadData(resources.getString(R.string.help_string), "text/html; charset=utf-8", "UTF-8")
    }

    private fun setupPresenter() {
        presenter = AboutActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onNavigateUp(): Boolean {
        finish()
        return super.onNavigateUp()
    }
    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, AboutActivity::class.java)
        }
    }
}
