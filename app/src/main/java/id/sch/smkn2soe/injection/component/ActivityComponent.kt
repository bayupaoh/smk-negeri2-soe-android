package id.sch.smkn2soe.injection.component

import id.sch.smkn2soe.injection.PerActivity
import id.sch.smkn2soe.injection.module.ActivityModule
import id.sch.smkn2soe.features.base.BaseActivity
import id.sch.smkn2soe.features.detail.DetailActivity
import id.sch.smkn2soe.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
