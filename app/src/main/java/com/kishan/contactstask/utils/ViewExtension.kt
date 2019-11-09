/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 8:24 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 9/16/19 12:55 PM
 *
 */

package com.kishan.contactstask.utils

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity



fun View.getParentActivity():AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper){
        if(context is AppCompatActivity){
            return context
        }
        context = context.baseContext

    }
    return null
}