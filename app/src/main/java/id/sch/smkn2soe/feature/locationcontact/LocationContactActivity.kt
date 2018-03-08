package id.sch.smkn2soe.feature.locationcontact

import android.content.Context
import android.content.Intent
import android.os.Bundle

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_location_contact.*

class LocationContactActivity : BaseActivity(), LocationContactActivityView {

    private var presenter: LocationContactActivityPresenter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_location_contact

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
        setupPresenter()
    }

    private fun setupUI() {
        setSupportActionBar(toolbarLocation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Kontak Dan Lokasi"

        imgLocationContact.setImageURI("https://lh5.googleusercontent.com/p/AF1QipMzcw_6gO0Ull-EXhXJMEAi2eroxVKm2sBWk4n0=w314-h168-p-k-no")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    private fun setupPresenter() {
        presenter = LocationContactActivityPresenter()
        presenter!!.attachView(this)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, LocationContactActivity::class.java)
        }
    }
}
