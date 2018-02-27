package id.sch.smknn2soe.feature.home

import android.view.View
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smknn2soe.model.dummy.DummyDataArticle
import id.sch.smknn2soe.model.dummy.DummyDataHead
import kotlinx.android.synthetic.main.layout_home_head.view.*

/**
 * Created by King Oil on 26/02/2018.
 */
class HomeHeadItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataHead>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: DummyDataHead?) {
        itemView.layoutHomeTitle.text = data?.title
        itemView.layoutHomeViewMore.text = "View More"

        var adapter = HomeContentAdapter(itemView.context)
        itemView.layoutHomeRecHome.setUpAsList()
        itemView.layoutHomeRecHome.setPullRefreshEnabled(false)
        itemView.layoutHomeRecHome.setLoadingMoreEnabled(false)
        itemView.layoutHomeRecHome.adapter = adapter

        var dataItem = DummyDataArticle()
        dataItem.title = "Acara pentas seni siswa berjalan sukses di gor nekmese"
        dataItem.date = "12 januari 2017"
        dataItem.imageUrl = "http://setara-institute.org/wp-content/uploads/2017/09/1494013633778-Screen-Shot-2017-05-05-at-72946-PM-660x330.jpg"

        adapter?.add(dataItem)
        adapter?.add(dataItem)
        adapter?.notifyDataSetChanged()
    }
}