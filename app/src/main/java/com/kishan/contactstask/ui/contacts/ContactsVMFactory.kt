/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 9:01 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/7/19 10:30 AM
 *
 */

package com.kishan.contactstask.ui.contacts

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ContactsVMFactory(var context: Context): ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactListViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}