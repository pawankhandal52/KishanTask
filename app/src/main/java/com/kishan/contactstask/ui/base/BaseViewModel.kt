package com.kishan.contactstask.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kishan.contactstask.utils.ApiList
import com.kishan.contactstask.utils.NetworkModule
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
    var postApi: ApiList = NetworkModule.getApis()
     lateinit var subscription: Disposable

    val loadingBar: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    /**
     * this method is used to change the value of loadingBar
     * when api call start it set the value true
     *
     */
    protected fun onApiCallStart(){
        loadingBar.value = true
    }

    /**
      *  this method is used to change the value of loadingBar
     * when api call start it set the value false     *
     */
    protected fun onApiCallFinish(){
        loadingBar.value = false

    }
}