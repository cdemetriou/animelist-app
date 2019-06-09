package com.findme.app

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.View
import com.findme.app.base.BaseActivity
import com.findme.app.data.remote.Repository
import com.findme.app.databinding.ActivityMainBinding
import com.findme.app.utils.PreferencesManager
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