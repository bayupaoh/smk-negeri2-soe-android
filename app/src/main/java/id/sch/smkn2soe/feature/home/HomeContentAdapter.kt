package id.sch.smkn2soe.feature.home

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataArticle
import id.sch.smkn2soe.model.dummy.DummyDataEvent

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeContentAdapter(context: Context) : BaseRecyclerAdapter<Any, HomeContentItemView>(context) {
    val ITEM_TYPE_ARTICLE = 1
    val ITEM_TYPE_EVENT = 2
    val ITEM_TYPE_CALENDAR = 3

    override fun getItemResourceLayout(viewType: Int): Int {
        if (viewType == ITEM_TYPE_ARTICLE) {
            return R.layout.layout_home_content_article_item
        } else if (viewType == ITEM_TYPE_EVENT) {
            return R.layout.layout_home_content_event_item
        } else {
            return R.layout.layout_home_content_calendar_item
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is DummyDataArticle) {
            return ITEM_TYPE_ARTICLE
        } else if (datas.get(position) is DummyDataEvent) {
            return ITEM_TYPE_EVENT
        } else {
            return ITEM_TYPE_CALENDAR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentItemView {
        return HomeContentItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
    }
}