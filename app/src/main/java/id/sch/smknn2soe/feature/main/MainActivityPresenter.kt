package id.sch.smknn2soe.feature.main

import android.content.Context
import id.sch.smknn2soe.BaseApplication
import id.sch.smknn2soe.base.presenter.BasePresenter
import id.sch.smknn2soe.helper.PreferenceManager

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by King Oil on 16/02/2018.
 */

class MainActivityPresenter : BasePresenter<MainActivityView> {
    private var view: MainActivityView? = null
    private val mCompositeDisposable: CompositeDisposable? = null
    private var preferencesManager: PreferenceManager? = null

    override fun attachView(view: MainActivityView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        mCompositeDisposable?.clear()
    }

    fun getDataFirstInstall():Boolean{
        preferencesManager = PreferenceManager.instance()
        preferencesManager!!.mApplicationContext = BaseApplication.appContext
        return preferencesManager!!.isFirtInstall
    }

    fun setDataFirstInstall(boolean: Boolean){
        preferencesManager = PreferenceManager.instance()
        preferencesManager!!.mApplicationContext = BaseApplication.appContext
        preferencesManager!!.isFirtInstall = boolean
    }

}
