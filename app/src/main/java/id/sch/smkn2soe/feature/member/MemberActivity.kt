package id.sch.smkn2soe.feature.member

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jcodecraeer.xrecyclerview.XRecyclerView
import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.model.User
import kotlinx.android.synthetic.main.activity_member.*

/**
 * Created by DODYDMW19 on 1/30/2018.
 */

class MemberActivity : BaseActivity(), MemberView , MemberItemView.OnActionListener{

    private var memberPresenter: MemberPresenter? = null
    private var currentPage: Int = 1
    private var adapter: MemberAdapter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_member

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupToolbar(mToolbar, false)
        setupPresenter()
    }

    private fun setupPresenter() {
        memberPresenter = MemberPresenter()
        memberPresenter?.attachView(this)
        memberPresenter?.getMember(currentPage)
    }

    private fun initProduct() {
        adapter = MemberAdapter(this)
        adapter?.setOnActionListener(this)

        memberList.setUpAsList()

        memberList.adapter = adapter
        memberList.setPullRefreshEnabled(true)
        memberList.setLoadingMoreEnabled(true)
        memberList.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onRefresh() {
                currentPage = 1
                memberPresenter?.getMember(currentPage)
            }

            override fun onLoadMore() {
                currentPage++
                memberPresenter?.getMember(currentPage)
            }
        })

    }

    private fun setData(data: List<User>?) {
        if (data != null) {
            if (currentPage == 1) {
                emptyState.visibility = View.GONE
                memberList.visibility = View.VISIBLE
                if (adapter != null) {
                    adapter?.clear()
                }
            }
            adapter?.add(data)
        }
    }

    override val context: Context
        get() = this

    override fun showMembers(members: List<User>?) {
        members.let {
            if (members != null && members.isNotEmpty()) {
                progressBar.visibility = View.GONE
                if (currentPage == 1) {
                    initProduct()
                }
                setData(members)

                memberList.refreshComplete()
                memberList.loadMoreComplete()
            }
        }
    }

    override fun onFailed(message: String?) {
        message.let {
            showToast(message!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        memberPresenter?.let {
            memberPresenter?.detachView()
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MemberActivity::class.java)
        }
    }

    override fun onClicked(view: MemberItemView) {
       view.getData().let {
           showToast(view.getData().firstName!!)
       }
    }
}
