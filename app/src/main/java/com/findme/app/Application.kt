package com.findme.app

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.squareup.leakcanary.LeakCanary
import com.findme.app.injection.AppComponent
import com.findme.app.injection.AppModule
import com.findme.app.injection.DaggerAppComponent
import com.findme.app.injection.NetworkModule
import android.support.multidex.MultiDex



class Application: MultiDexApplication() {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }

        LeakCanary.install(this)

        /*val analytics = FirebaseAnalytics.getInstance(this)
        analytics.setAnalyticsCollectionEnabled(!BuildConfig.DEBUG)*/

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()


    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }

    fun getMyComponent(): AppComponent {
        return appComponent
    }
}