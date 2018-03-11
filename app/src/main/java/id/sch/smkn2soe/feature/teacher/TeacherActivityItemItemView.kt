package id.sch.smkn2soe.feature.teacher

import android.view.View
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.base.ui.adapter.viewholder.BaseItemViewHolder
import id.sch.smkn2soe.model.dummy.DummyDataTeacher
import kotlinx.android.synthetic.main.layout_teacher_item.view.*

/**
 * Created by King Oil on 11/03/2018.
 */
class TeacherActivityItemItemView(itemView: View, mItemClickListener: BaseRecyclerAdapter.OnItemClickListener?, mLongItemClickListener: BaseRecyclerAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<DummyDataTeacher>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: DummyDataTeacher?) {
        itemView.layoutTeacherImg.setImageURI(data?.imageUrl)
        itemView.layoutTeacherTitle.text = data?.name
    }
}