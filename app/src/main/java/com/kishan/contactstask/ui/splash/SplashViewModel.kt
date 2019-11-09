/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:39 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:39 PM
 *
 */

package com.kishan.contactstask.ui.splash

import androidx.lifecycle.MutableLiveData
import com.kishan.contactstask.ui.base.BaseViewModel


class SplashViewModel: BaseViewModel() {
    val nextButtonClick = MutableLiveData<Boolean>()

    /**
     * Function to change the value of @sample{nextButtonClick} from View
     *
     */
    fun onNext(){
        nextButtonClick.value = true
    }
}