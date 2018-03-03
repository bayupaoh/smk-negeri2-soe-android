package id.sch.smkn2soe.di.module

import android.content.Context
import id.sch.smkn2soe.di.scope.SuitCoreApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {
    private val appContext = context.applicationContext

    @Provides
    @SuitCoreApplicationScope
    fun context(): Context {
        return this.appContext
    }
}
