package id.sch.smknn2soe.feature.home

import android.os.Build
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.view.View
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smknn2soe.model.dummy.DummyDataArticle
import id.sch.smknn2soe.model.dummy.DummyDataCalendar
import id.sch.smknn2soe.model.dummy.DummyDataEvent
import kotlinx.android.synthetic.main.layout_home_content_article.view.*
import kotlinx.android.synthetic.main.layout_home_content_calendar.view.*
import kotlinx.android.synthetic.main.layout_home_content_event.view.*

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeContentItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: Any?) {
        if (data is DummyDataArticle) {
            var item = data as DummyDataArticle
            itemView.layoutHomeContentArticleTitle.text = item?.title
            itemView.layoutHomeContentArticleDate.text = item?.date
            itemView.layoutHomeContentArticleImg.setImageURI(item?.imageUrl)
        } else if (data is DummyDataEvent) {
            var item = data as DummyDataEvent
            itemView.layoutHomeContentEventTitle.text = item?.title
            itemView.layoutHomeContentEventDate.text = item?.date
            itemView.layoutHomeContentEventLocation.text = item?.location
            itemView.layoutHomeContentEventImg.setImageURI(item?.imageUrl)
        } else if (data is DummyDataCalendar) {
            var item = data as DummyDataCalendar
            itemView.layoutHomeCalendarTitle.text = item?.title
            itemView.layoutHomeCalendarDate.text = item?.date
            itemView.layoutHomeCalendarMonth.text = item?.month
        }
    }
}