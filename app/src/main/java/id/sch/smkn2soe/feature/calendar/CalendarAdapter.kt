package id.sch.smkn2soe.feature.calendar

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataHeaderCalendar

/**
 * Created by King Oil on 03/03/2018.
 */
class CalendarAdapter(context: Context) : BaseRecyclerAdapter<Any, CalendarItemView>(context)  {
    val ITEM_TYPE_CALENDAR = 1
    val ITEM_TYPE_HEADER_CALENDAR = 2

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is DummyDataHeaderCalendar) {
            return ITEM_TYPE_HEADER_CALENDAR
        } else {
            return ITEM_TYPE_CALENDAR
        }
    }

    override fun getItemResourceLayout(viewType: Int): Int {
        if (viewType == ITEM_TYPE_HEADER_CALENDAR) {
            return R.layout.layout_calendar_head_item
        } else {
            return R.layout.layout_calendar_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarItemView = CalendarItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}