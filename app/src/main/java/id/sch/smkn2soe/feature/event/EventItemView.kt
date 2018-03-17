package id.sch.smkn2soe.feature.event

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataEvent
import id.sch.smkn2soe.model.dummy.DummyDataHeaderEvent
import kotlinx.android.synthetic.main.layout_event_header_item.view.*
import kotlinx.android.synthetic.main.layout_event_item.view.*

/**
 * Created by King Oil on 03/03/2018.
 */
class EventItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    private var mActionListener: OnActionListener? = null
    private var data: Any? = null

    override fun bind(data: Any?) {
        this.data = data
        if (data is DummyDataHeaderEvent) {
            var item = data as DummyDataHeaderEvent
            itemView.layoutHeaderEventImg.setImageURI(item?.imageUrl)
            itemView.layoutHeaderEventTitle.text = item?.title
            itemView.layoutHeaderEvenDate.text = item?.date
            itemView.layoutHeaderEvenLocation.text = item?.location
        } else if (data is DummyDataEvent) {
            var item = data as DummyDataEvent
            itemView.layoutItemEventImg.setImageURI(item?.imageUrl)
            itemView.layoutItemEventTitle.text = item?.title
            itemView.layoutItemEventDate.text = item?.date
            itemView.layoutItemEventLocation.text = item?.location
        }

        itemView.setOnClickListener { view -> mActionListener?.onClicked(this) }
    }

    fun getData(): Any? = data

    fun setOnActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    interface OnActionListener {
        fun onClicked(view: EventItemView?)
    }

}