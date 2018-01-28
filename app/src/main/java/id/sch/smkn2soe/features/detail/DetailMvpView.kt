package id.sch.smkn2soe.features.detail

import id.sch.smkn2soe.data.model.Pokemon
import id.sch.smkn2soe.data.model.Statistic
import id.sch.smkn2soe.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}