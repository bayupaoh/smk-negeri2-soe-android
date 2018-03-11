package id.sch.smkn2soe.feature.teacher

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataHeaderTeacher
import kotlinx.android.synthetic.main.layout_teacher_header_item.view.*

/**
 * Created by King Oil on 11/03/2018.
 */
class TeacherActivityHeaderItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataHeaderTeacher>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: DummyDataHeaderTeacher?) {
        itemView.layoutTeacherHeaderTitle.text = data?.job

        var adapter= TeacherActivityItemAdapter(itemView.context)
        itemView.layoutTeacherRec.setUpAsGridInScroll(2)
        itemView.layoutTeacherRec.adapter = adapter
        itemView.layoutTeacherRec.setLoadingMoreEnabled(false)
        itemView.layoutTeacherRec.setPullRefreshEnabled(false)

        data?.content?.let { adapter.addAll(it) }
        adapter?.notifyDataSetChanged()
    }
}