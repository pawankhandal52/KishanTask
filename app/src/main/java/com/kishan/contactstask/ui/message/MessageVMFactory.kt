/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 5:27 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 5:27 PM
 *
 */

package com.kishan.contactstask.ui.message

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kishan.contactstask.database.AppDatabase

class MessageVMFactory(private val owner: LifecycleOwner, var context: Context):ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MessageViewModel::class.java)) {
            val db = AppDatabase.getDatabase(context)
            @Suppress("UNCHECKED_CAST")
            return MessageViewModel(owner,db.dao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}