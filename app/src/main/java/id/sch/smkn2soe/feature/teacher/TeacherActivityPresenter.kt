package id.sch.smkn2soe.feature.teacher

import id.sch.smkn2soe.base.presenter.BasePresenter

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class TeacherActivityPresenter : BasePresenter<TeacherActivityView> {
    private var view: TeacherActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null

    override fun attachView(view: TeacherActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }
}
