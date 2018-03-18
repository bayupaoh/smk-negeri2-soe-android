package id.sch.smkn2soe.feature.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity(), SettingActivityView {

    private var presenter: SettingActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_setting

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarSetting)
        supportActionBar?.title = "Setting"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupPresenter() {
        presenter = SettingActivityPresenter()
        presenter!!.attachView(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, SettingActivity::class.java)
        }
    }
}
