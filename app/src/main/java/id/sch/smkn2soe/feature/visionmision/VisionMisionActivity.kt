package id.sch.smkn2soe.feature.visionmision

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_vision_mision.*

class VisionMisionActivity : BaseActivity(), VisionMisionActivityView {

    private var presenter: VisionMisionActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_vision_mision

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarVisionMision)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Visi Misi"

        imgVisionMision.setImageURI("http://smkn2soe.sch.id/newportal/images/galeri/gb18.jpg")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setupPresenter() {
        presenter = VisionMisionActivityPresenter()
        presenter!!.attachView(this)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, VisionMisionActivity::class.java)
        }
    }
}
