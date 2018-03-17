package id.sch.smkn2soe.feature.home

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataArticle
import id.sch.smkn2soe.model.dummy.DummyDataCalendar
import id.sch.smkn2soe.model.dummy.DummyDataEvent
import kotlinx.android.synthetic.main.layout_home_content_article_item.view.*
import kotlinx.android.synthetic.main.layout_home_content_calendar_item.view.*
import kotlinx.android.synthetic.main.layout_home_content_event_item.view.*

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeContentItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    private var mActionListener: OnActionListener? = null
    private var data: Any? = null

    override fun bind(data: Any?) {
        this.data = data
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
        itemView.setOnClickListener { view -> mActionListener?.onClicked(this) }
    }
    
    fun getData(): Any? = data

    fun setOnActionListener(mActionListener: OnActionListener?) {
        this.mActionListener = mActionListener
    }

    interface OnActionListener {
        fun onClicked(view: HomeContentItemView?)
    }

}