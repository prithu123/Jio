package com.launcher.jio

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.launcher.jio.databinding.AppItemBinding
import com.launcher.launchsdk.ApplicationDetails
import java.util.ArrayList

class CustomAdapter( val apps : MutableList<ApplicationDetails>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return apps.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val appInfo = apps[position]
        (holder as CustomAdapter.RecyclerHolderCatIcon).bind(appInfo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = AppItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderCatIcon(applicationBinding)
    }


    inner class RecyclerHolderCatIcon(private var applicationBinding: AppItemBinding) :
        RecyclerView.ViewHolder(applicationBinding.root) {

        fun bind(appInfo: ApplicationDetails) {
            applicationBinding.app = appInfo
            applicationBinding.image.setOnClickListener { v ->
                run {
                    appInfo.onAppSelected(v)
                };

            }


        }
    }
}