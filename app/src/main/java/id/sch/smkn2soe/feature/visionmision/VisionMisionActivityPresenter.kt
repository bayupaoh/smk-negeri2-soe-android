package id.sch.smkn2soe.feature.visionmision

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class VisionMisionActivityPresenter : BasePresenter<VisionMisionActivityView> {
    private var view: VisionMisionActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: VisionMisionActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
