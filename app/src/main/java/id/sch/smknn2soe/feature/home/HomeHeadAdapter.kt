package id.sch.smknn2soe.feature.home

import android.content.Context
import android.view.ViewGroup
import id.sch.smknn2soe.R
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.model.dummy.DummyDataHead

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeHeadAdapter(context: Context) : BaseRecyclerAdapter<DummyDataHead, HomeHeadItemView>(context) {
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.layout_home_head

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHeadItemView = HomeHeadItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}