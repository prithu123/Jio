package com.launcher.jio

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.launcher.launchsdk.ApplicationDetails

@BindingAdapter("app:items")
fun setListAdapter(list: RecyclerView, items: MutableList<ApplicationDetails>) {
    list.layoutManager = LinearLayoutManager(list.context)
    list.adapter = CustomAdapter(items)

}


