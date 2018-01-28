package id.sch.smkn2soe.injection.component

import id.sch.smkn2soe.data.DataManager
import id.sch.smkn2soe.data.remote.MvpStarterService
import id.sch.smkn2soe.injection.ApplicationContext
import id.sch.smkn2soe.injection.module.ApplicationModule
import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun mvpBoilerplateService(): MvpStarterService
}
