package id.sch.smkn2soe.feature.news

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataArticle
import id.sch.smkn2soe.model.dummy.DummyDataHeaderArticle
import kotlinx.android.synthetic.main.layout_article_header_item.view.*
import kotlinx.android.synthetic.main.layout_article_item.view.*

/**
 * Created by King Oil on 01/03/2018.
 */
class NewsItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<Any>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: Any?) {
        if (data is DummyDataHeaderArticle) {
            var item = data as DummyDataHeaderArticle
            itemView.layoutHeaderArticleImg.setImageURI(item?.imageUrl)
            itemView.layoutHeaderArticleTitle.text = item?.title
            itemView.layoutHeaderArticleDate.text = item?.date
        } else if (data is DummyDataArticle) {
            var item = data as DummyDataArticle
            itemView.layoutArticleImg.setImageURI(item?.imageUrl)
            itemView.layoutArticleDate.text = item?.date
            itemView.layoutArticleTitle.text = item?.title
        }
    }
}