package com.template.app.base

import android.support.v7.app.AppCompatActivity
import com.template.app.Application
import com.template.app.injection.AppComponent

open class BaseActivity: AppCompatActivity() {

    fun getComponent(): AppComponent {
        return (applicationContext as Application).getMyComponent()
    }
}