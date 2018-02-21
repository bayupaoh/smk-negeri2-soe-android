package id.sch.smknn2soe.feature.member

import android.content.Context
import android.view.ViewGroup
import id.sch.smknn2soe.R
import id.sch.smknn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smknn2soe.model.User

/**
 * Created by DODYDMW19 on 1/30/2018.
 */
class MemberAdapter(context: Context) : BaseRecyclerAdapter<User, MemberItemView>(context) {

    private var mOnActionListener: MemberItemView.OnActionListener? = null

    fun setOnActionListener(onActionListener: MemberItemView.OnActionListener) {
        mOnActionListener = onActionListener
    }

    override fun getItemResourceLayout(viewType: Int): Int = R.layout.item_member

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MemberItemView{
        val view = MemberItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
        mOnActionListener?.let { view.setOnActionListener(it) }
        return view
    }
}
