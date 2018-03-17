package id.sch.smkn2soe.feature.event

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataHeaderEvent

/**
 * Created by King Oil on 03/03/2018.
 */
class EventAdapter(context: Context) : BaseRecyclerAdapter<Any, EventItemView>(context) {
    val ITEM_TYPE_EVENT = 1
    val ITEM_TYPE_HEADER_EVENT = 2

    private var mActionListener: EventItemView.OnActionListener? = null

    fun setActionListener(mActionListener: EventItemView.OnActionListener?) {
        this.mActionListener = mActionListener
    }

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is DummyDataHeaderEvent) {
            return ITEM_TYPE_HEADER_EVENT
        } else {
            return ITEM_TYPE_EVENT
        }
    }

    override fun getItemResourceLayout(viewType: Int): Int {
        if (viewType == ITEM_TYPE_HEADER_EVENT) {
            return R.layout.layout_event_header_item
        } else {
            return R.layout.layout_event_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItemView {
        val view = EventItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
        view.setOnActionListener(mActionListener)
        return view
    }
}