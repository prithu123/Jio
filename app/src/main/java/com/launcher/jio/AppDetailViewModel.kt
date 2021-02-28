package com.launcher.jio

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.launcher.launchsdk.AppInfoRepo
import com.launcher.launchsdk.ApplicationDetails
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AppDetailViewModel(application: Application) : AndroidViewModel(application) {
     var list: MutableLiveData<List<ApplicationDetails>> = MutableLiveData(emptyList())

    init {


        AppInfoRepo.setApplication(application)
        updateAppsList()
    }

    fun updateAppsList() {
        AppInfoRepo.getAppsInfoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    if (result != null) {
                        list?.value = result
                    }
                },
                { error ->
                    println(error.localizedMessage)
                }
            )
    }
}