/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:33 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:33 PM
 *
 */



package com.kishan.contactstask.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.kishan.contactstask.R

class ProgressDialog(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCancelable(false)
        setCanceledOnTouchOutside(false)

    }
}