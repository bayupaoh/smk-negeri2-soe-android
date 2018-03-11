package id.sch.smkn2soe.feature.extrakurikuler

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class ExtraKurikulerActivityPresenter : BasePresenter<ExtraKurikulerActivityView> {
    private var view: ExtraKurikulerActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: ExtraKurikulerActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
