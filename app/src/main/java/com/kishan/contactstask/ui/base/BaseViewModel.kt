package com.kishan.contactstask.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kishan.contactstask.utils.NetworkModule
import com.kishan.contactstask.utils.ApiList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Pawan Kumar Sharma on 23-Oct-19.
 * Fleeca India Pvt Ltd
 * Android Developer
 * android_developer1@fleeca.in
 * +917737947610
 */
abstract class BaseViewModel() : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    var postApi: ApiList = NetworkModule.getApis("")
     lateinit var subscription: Disposable

    val loadingBar: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    protected fun onApiCallStart(){
        loadingBar.value = true
    }
    protected fun onApiCallFinish(){
        loadingBar.value = false

    }
}