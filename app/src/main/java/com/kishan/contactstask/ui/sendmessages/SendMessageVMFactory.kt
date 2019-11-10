/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 12:09 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 9:03 PM
 *
 */

package com.kishan.contactstask.ui.sendmessages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kishan.contactstask.ui.contacts.model.Contact


class SendMessageVMFactory(var contact: Contact): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SendMessageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SendMessageViewModel(contact) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}