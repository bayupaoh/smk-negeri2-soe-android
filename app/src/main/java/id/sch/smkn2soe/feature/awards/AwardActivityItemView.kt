package id.sch.smkn2soe.feature.awards

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataAward
import id.sch.smkn2soe.model.dummy.DummyDataHead
import id.sch.smkn2soe.model.dummy.DummyDataHeaderAward
import kotlinx.android.synthetic.main.layout_award_head_item.view.*
import kotlinx.android.synthetic.main.layout_award_item.view.*

/**
 * Created by King Oil on 11/03/2018.
 */
class AwardActivityItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: Any?) {
        if (data is DummyDataHeaderAward) {
            itemView.layoutAwardTitleYear.text = data?.year
        } else if (data is DummyDataAward) {
            itemView.layoutAwardImg.setImageURI(data?.imageUrl)
            itemView.layoutAwardTitle.text = data?.title
        }
    }
}