package id.sch.smkn2soe.feature.awards

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class AwardActivityPresenter : BasePresenter<AwardActivityView> {
    private var view: AwardActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: AwardActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
