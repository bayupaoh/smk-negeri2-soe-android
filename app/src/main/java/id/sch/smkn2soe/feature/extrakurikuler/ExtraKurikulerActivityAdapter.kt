package id.sch.smkn2soe.feature.extrakurikuler

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataExtraKurikuler

/**
 * Created by King Oil on 11/03/2018.
 */
class ExtraKurikulerActivityAdapter(context: Context) : BaseRecyclerAdapter<DummyDataExtraKurikuler, ExtraKurikulerActivityItemView>(context) {
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.layout_extrakurikuler_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraKurikulerActivityItemView = ExtraKurikulerActivityItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}