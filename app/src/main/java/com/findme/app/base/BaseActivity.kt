package com.findme.app.base

import android.support.v7.app.AppCompatActivity
import com.findme.app.Application
import com.findme.app.injection.AppComponent

open class BaseActivity: AppCompatActivity() {

    fun getComponent(): AppComponent {
        return (applicationContext as Application).getMyComponent()
    }
}