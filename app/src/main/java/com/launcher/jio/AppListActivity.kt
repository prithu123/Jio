package com.launcher.jio

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.launcher.jio.databinding.ActivityScrollingBinding

class AppListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ActivityScrollingBinding = DataBindingUtil.setContentView<ActivityScrollingBinding>(
            this,
            R.layout.activity_scrolling
        )
        ActivityScrollingBinding.setLifecycleOwner(this)
        ActivityScrollingBinding.vm=  ViewModelProvider(this).get(AppDetailViewModel::class.java)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }


}