package id.sch.smknn2soe.feature.home

import android.os.Build
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.view.View
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smknn2soe.model.dummy.DummyDataArticle
import kotlinx.android.synthetic.main.layout_home_content.view.*
import kotlinx.android.synthetic.main.layout_home_head.view.*

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeContentItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataArticle>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: DummyDataArticle?) {
        itemView.layoutHomeContentTitle.text = data?.title
        itemView.layoutHomeContentDate.text = data?.date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            itemView.layoutHomeContentDate.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
        itemView.layoutHomeContentImg.setImageURI(data?.imageUrl)
    }
}