package com.launcher.launchsdk

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.LinearLayout

data class ApplicationDetails(
    val applicationName: String?,
    val packageName: String?,
    val appIcon: Drawable?,
    val mainActivityName: String?,
    val versionCode: String?,
    val versionName: String?
){
   val onAppSelected= fun (view: View) {
        if(this.packageName!=null){
            val intent = view.context.packageManager.getLaunchIntentForPackage(this.packageName ?: "");
            view.context.startActivity(intent)
        }
    }
}

