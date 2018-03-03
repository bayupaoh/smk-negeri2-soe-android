package id.sch.smkn2soe.feature.home

import android.util.Log
import android.view.View
import com.google.gson.Gson
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.helper.Shortcut
import id.sch.smkn2soe.model.dummy.DummyDataHead
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

        data?.content?.let { adapter?.addAll(it) }
        Log.i(Shortcut.LOG,Gson().toJson(data?.content))
        adapter?.notifyDataSetChanged()
    }
}