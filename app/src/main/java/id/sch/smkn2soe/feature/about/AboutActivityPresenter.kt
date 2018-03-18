package id.sch.smkn2soe.feature.about

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class AboutActivityPresenter : BasePresenter<AboutActivityView> {
    private var view: AboutActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: AboutActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
