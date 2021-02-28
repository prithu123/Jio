package com.launcher.launchsdk

import android.app.Application
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import io.reactivex.rxjava3.core.Single


object AppInfoRepo {
    lateinit var applicationLaunch: Application
    fun setApplication(application: Application) {
        applicationLaunch = application
    }

    fun getAppsInfoList():Single<List<ApplicationDetails>> {
        val pm: PackageManager = applicationLaunch.packageManager
        val apps: MutableList<ApplicationDetails> = ArrayList<ApplicationDetails>()
        val packs: List<PackageInfo> = pm.getInstalledPackages(0)
        for (i in packs.indices) {
            val p = packs[i]
            if (!isSystemPackage(p)) {
                val appName = p.applicationInfo.loadLabel(pm).toString()
                val icon = p.applicationInfo.loadIcon(pm)
                val packages = p.applicationInfo.packageName
                val activityInfo= if (p.activities!=null && p.activities.size>0) p.activities[0].parentActivityName else ""
                val versionName=p.versionName
                val versionCode= if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                    p.longVersionCode.toString()
                } else {
                    p.versionCode.toString()
                }
                apps.add(
                    ApplicationDetails(
                        appName, packages, icon,
                        activityInfo,versionCode, versionName
                    )
                )
            }
        }

        return Single.just(apps.sortedWith(compareBy({it.applicationName})))
    }

    private fun isSystemPackage(pkgInfo: PackageInfo): Boolean {
        return pkgInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }
}