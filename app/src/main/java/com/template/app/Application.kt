package com.template.app

import android.support.multidex.MultiDexApplication
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.leakcanary.LeakCanary
import com.template.app.injection.AppComponent
import com.template.app.injection.AppModule
import com.template.app.injection.DaggerAppComponent
import com.template.app.injection.NetworkModule

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

    fun getMyComponent(): AppComponent {
        return appComponent
    }
}