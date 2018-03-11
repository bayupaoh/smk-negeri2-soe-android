package id.sch.smkn2soe.feature.extrakurikuler

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataExtraKurikuler
import kotlinx.android.synthetic.main.layout_extrakurikuler_item.view.*

/**
 * Created by King Oil on 11/03/2018.
 */
class ExtraKurikulerActivityItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataExtraKurikuler>(itemView, mItemClickListener, mLongItemClickListener) {

    override fun bind(data: DummyDataExtraKurikuler?) {
        itemView.layoutExtraKurikulerImg.setImageURI(data?.imageUrl)
        itemView.layoutExtraKurikulerTitle.text = data?.title
    }

}