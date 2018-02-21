package id.sch.smknn2soe.base.presenter


interface BasePresenter<V> {

    fun attachView(view: V)

    fun detachView()

}
