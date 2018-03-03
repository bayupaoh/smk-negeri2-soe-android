package id.sch.smkn2soe.feature.calendar

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataCalendar
import id.sch.smkn2soe.model.dummy.DummyDataHeaderCalendar
import kotlinx.android.synthetic.main.layout_calendar_head_item.view.*
import kotlinx.android.synthetic.main.layout_calendar_item.view.*

/**
 * Created by King Oil on 03/03/2018.
 */
class CalendarItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: Any?) {
        if (data is DummyDataHeaderCalendar) {
            var item = data as DummyDataHeaderCalendar
            itemView.layoutCalendarTitle.text = item.month + " " + item.year
        } else if (data is DummyDataCalendar) {
            var item = data as DummyDataCalendar
            itemView.layoutItemCalendarDate.text = item.date
            itemView.layoutItemCalendarDay.text = item.day
            itemView.layoutItemCalendarTitle.text = item.title
        }
    }
}