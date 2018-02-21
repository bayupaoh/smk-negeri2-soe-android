package id.sch.smknn2soe

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import butterknife.ButterKnife
import com.facebook.drawee.backends.pipeline.Fresco
import id.sch.smknn2soe.di.component.ApplicationComponent
import id.sch.smknn2soe.di.component.DaggerApplicationComponent
import id.sch.smknn2soe.di.module.ContextModule
import id.sch.smknn2soe.helper.RxBus
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by DODYDMW19 on 1/30/2018.
 */

class BaseApplication : MultiDexApplication() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
        lateinit var bus: RxBus
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
        bus = RxBus()
        appContext = applicationContext
        ButterKnife.setDebug(true)
        Fresco.initialize(this)

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)


    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
