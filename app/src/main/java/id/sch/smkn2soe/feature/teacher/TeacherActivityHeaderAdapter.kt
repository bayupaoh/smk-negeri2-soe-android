package id.sch.smkn2soe.feature.teacher

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataHeaderTeacher

/**
 * Created by King Oil on 11/03/2018.
 */
class TeacherActivityHeaderAdapter(context: Context) : BaseRecyclerAdapter<DummyDataHeaderTeacher, TeacherActivityHeaderItemView>(context) {
    private var mActionListener: TeacherActivityItemItemView.OnActionListener? = null

    fun setActionListener(mActionListener: TeacherActivityItemItemView.OnActionListener?) {
        this.mActionListener = mActionListener
    }

    override fun getItemResourceLayout(viewType: Int): Int = R.layout.layout_teacher_header_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherActivityHeaderItemView {
        val view = TeacherActivityHeaderItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
        view.setActionListener(mActionListener)
        return view
    }
}