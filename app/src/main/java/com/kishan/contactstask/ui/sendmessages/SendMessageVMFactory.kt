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
    override fun <SendMessageViewModel : ViewModel?> create(modelClass: Class<SendMessageViewModel>): SendMessageViewModel {
        return SendMessageViewModel(contact) as SendMessageViewModel
    }
}