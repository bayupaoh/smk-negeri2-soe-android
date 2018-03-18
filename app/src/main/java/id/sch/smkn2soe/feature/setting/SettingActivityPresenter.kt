package id.sch.smkn2soe.feature.setting

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class SettingActivityPresenter : BasePresenter<SettingActivityView> {
    private var view: SettingActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: SettingActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
