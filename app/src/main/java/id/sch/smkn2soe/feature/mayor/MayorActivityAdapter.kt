package id.sch.smkn2soe.feature.mayor

import android.content.Context
import android.view.ViewGroup
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.adapter.BaseRecyclerAdapter
import id.sch.smkn2soe.model.dummy.DummyDataMayor

/**
 * Created by King Oil on 11/03/2018.
 */
class MayorActivityAdapter(context: Context) : BaseRecyclerAdapter<DummyDataMayor, MayorActivityItemView>(context) {
    private var mActionListener: MayorActivityItemView.OnActionListener? = null

    fun setActionListener(mActionListener: MayorActivityItemView.OnActionListener?) {
        this.mActionListener = mActionListener
    }

    override fun getItemResourceLayout(viewType: Int): Int = R.layout.layout_mayor_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MayorActivityItemView {
        val view = MayorActivityItemView(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
        view.setOnActionListener(mActionListener)
        return view
    }
}