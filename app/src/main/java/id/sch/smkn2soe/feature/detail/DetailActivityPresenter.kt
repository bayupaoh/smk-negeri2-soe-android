package id.sch.smkn2soe.feature.detail

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class DetailActivityPresenter : BasePresenter<DetailActivityView> {
    private var view: DetailActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: DetailActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
