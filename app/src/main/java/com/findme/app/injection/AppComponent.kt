package com.findme.app.injection

import android.content.Context
import com.findme.app.Application
import com.findme.app.MainActivity
import com.findme.app.data.remote.Repository
import com.findme.app.utils.PreferencesManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules  = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun context(): Context
    fun application(): Application
    fun preferencesManager(): PreferencesManager
    fun repository(): Repository

    fun inject(mainActivity: MainActivity)

}