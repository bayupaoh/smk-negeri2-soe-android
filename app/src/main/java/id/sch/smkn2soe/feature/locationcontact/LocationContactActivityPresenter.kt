package id.sch.smkn2soe.feature.locationcontact

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class LocationContactActivityPresenter : BasePresenter<LocationContactActivityView> {
    private var view: LocationContactActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: LocationContactActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
