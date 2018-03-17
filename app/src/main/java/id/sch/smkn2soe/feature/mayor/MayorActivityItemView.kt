package id.sch.smkn2soe.feature.mayor

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataMayor
import kotlinx.android.synthetic.main.layout_mayor_item.view.*

/**
 * Created by King Oil on 11/03/2018.
 */
class MayorActivityItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataMayor>(itemView, mItemClickListener, mLongItemClickListener) {
    private var mActionListener: OnActionListener? = null
    private var data: DummyDataMayor? = null

    override fun bind(data: DummyDataMayor?) {
        this.data = data
        itemView.layoutMayorImg.setImageURI(data?.imageUrl)
        itemView.layoutMayorTitle.setText(data?.title)
        itemView.setOnClickListener { view -> mActionListener?.onClicked(this) }
    }

    fun getData(): DummyDataMayor? = data

    fun setOnActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    interface OnActionListener {
        fun onClicked(view: MayorActivityItemView?)
    }

}