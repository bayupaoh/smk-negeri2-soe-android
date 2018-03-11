package id.sch.smkn2soe.feature.mayor

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class MayorActivityPresenter : BasePresenter<MayorActivityView> {
    private var view: MayorActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: MayorActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
