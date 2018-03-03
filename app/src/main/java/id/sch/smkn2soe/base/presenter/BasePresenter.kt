package id.sch.smkn2soe.base.presenter


interface BasePresenter<V> {

    fun attachView(view: V)

    fun detachView()

}
