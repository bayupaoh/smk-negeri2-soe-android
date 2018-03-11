package id.sch.smkn2soe.feature.awards

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataHeaderAward
import id.sch.smkn2soe.model.dummy.DummyDataHeaderCalendar

/**
 * Created by King Oil on 11/03/2018.
 */
class AwardActivityAdapter(context: Context) : BaseRecyclerAdapter<Any, AwardActivityItemView>(context) {
    val ITEM_TYPE_AWARD = 1
    val ITEM_TYPE_HEADER_AWARD = 2

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is DummyDataHeaderAward) {
            return ITEM_TYPE_HEADER_AWARD
        } else {
            return ITEM_TYPE_AWARD
        }
    }

    override fun getItemResourceLayout(viewType: Int): Int {
        if (viewType == ITEM_TYPE_HEADER_AWARD) {
            return R.layout.layout_award_head_item
        } else {
            return R.layout.layout_award_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwardActivityItemView = AwardActivityItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}