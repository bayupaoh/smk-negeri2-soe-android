package id.sch.smkn2soe.common.injection.component

import id.sch.smkn2soe.common.injection.module.ApplicationTestModule
import id.sch.smkn2soe.injection.component.ApplicationComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : ApplicationComponent