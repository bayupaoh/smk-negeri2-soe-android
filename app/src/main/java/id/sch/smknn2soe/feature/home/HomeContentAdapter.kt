package id.sch.smknn2soe.feature.home

import android.content.Context
import android.view.ViewGroup
import id.sch.smknn2soe.R
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.model.dummy.DummyDataArticle

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeContentAdapter(context: Context) : BaseRecyclerAdapter<DummyDataArticle, HomeContentItemView>(context) {
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.layout_home_content

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentItemView = HomeContentItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}