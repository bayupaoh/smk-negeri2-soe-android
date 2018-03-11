package id.sch.smkn2soe.feature.schoolinfo


import android.os.Bundle
import android.support.v4.app.Fragment

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseFragment
import id.sch.smkn2soe.feature.visionmision.VisionMisionActivity
import id.sch.smkn2soe.feature.locationcontact.LocationContactActivity
import id.sch.smkn2soe.feature.mayor.MayorActivity
import id.sch.smkn2soe.feature.extrakurikuler.ExtraKurikulerActivity
import id.sch.smkn2soe.feature.awards.AwardActivity
import kotlinx.android.synthetic.main.fragment_school_info.*


/**
 * A simple [Fragment] subclass.
 */
class SchoolInfoFragment : BaseFragment() {
    override val resourceLayout: Int=R.layout.fragment_school_info

    override fun onViewReady(savedInstanceState: Bundle?) {
        schoolInfoVision.setOnClickListener { view ->  startActivity(VisionMisionActivity.createIntent(activity!!))}
        schoolInfoContactLocation.setOnClickListener { view ->  startActivity(LocationContactActivity.createIntent(activity!!))}
        schoolInfoMayor.setOnClickListener { view ->  startActivity(MayorActivity.createIntent(activity!!))}
        schoolInfoEkskul.setOnClickListener { view ->  startActivity(ExtraKurikulerActivity.createIntent(activity!!))}
        schoolInfoAward.setOnClickListener { view ->  startActivity(AwardActivity.createIntent(activity!!))}
    }


}// Required empty public constructor
