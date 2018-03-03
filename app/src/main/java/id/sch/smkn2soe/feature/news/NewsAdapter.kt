package id.sch.smkn2soe.feature.news

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataHeaderArticle

/**
 * Created by King Oil on 01/03/2018.
 */
class NewsAdapter(context: Context) : BaseRecyclerAdapter<Any, NewsItemView>(context) {
    val ITEM_TYPE_ARTICLE = 1
    val ITEM_TYPE_HEADER_ARTICLE = 2

    override fun getItemViewType(position: Int): Int {
        if (datas.get(position) is DummyDataHeaderArticle) {
            return ITEM_TYPE_HEADER_ARTICLE
        } else {
            return ITEM_TYPE_ARTICLE
        }
    }

    override fun getItemResourceLayout(viewType: Int): Int {
        if (viewType == ITEM_TYPE_HEADER_ARTICLE) {
            return R.layout.layout_article_header_item
        } else {
            return R.layout.layout_article_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemView = NewsItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}