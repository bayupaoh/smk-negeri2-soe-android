package id.sch.smkn2soe.base.ui.recyclerview

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet

import com.jcodecraeer.xrecyclerview.XRecyclerView

class BaseRecyclerView : XRecyclerView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    fun setUpAsList() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
    }

    fun setUpAsListHorizontal() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun setUpAsListInScroll() {
        setHasFixedSize(true)
        layoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
    }

    fun setUpAsGridInScroll(spanCount: Int) {
        setHasFixedSize(true)
        layoutManager = object : GridLayoutManager(context, spanCount) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
    }
}
