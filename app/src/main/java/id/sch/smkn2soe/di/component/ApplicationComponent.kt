package id.sch.smkn2soe.di.component

import id.sch.smkn2soe.di.module.APIServiceModule
import id.sch.smkn2soe.di.scope.SuitCoreApplicationScope
import id.sch.smkn2soe.feature.member.MemberPresenter
import dagger.Component

@SuitCoreApplicationScope
@Component(modules = [(APIServiceModule::class)])
interface ApplicationComponent {

    fun inject(memberPresenter: MemberPresenter)

}
