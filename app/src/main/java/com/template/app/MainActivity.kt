package com.template.app

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.View
import com.template.app.base.BaseActivity
import com.template.app.data.remote.Repository
import com.template.app.databinding.ActivityMainBinding
import com.template.app.utils.PreferencesManager
import javax.inject.Inject


class MainActivity: BaseActivity() {

    @Inject lateinit var preferencesManager: PreferencesManager
    @Inject lateinit var repository: Repository

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getComponent().inject(this)

        preferencesManager.setBoolean("Yo", true)
    }

    fun onClick(v: View) {
        Log.e("PREFS", preferencesManager.getBoolean("Yo", false).toString())
    }

}