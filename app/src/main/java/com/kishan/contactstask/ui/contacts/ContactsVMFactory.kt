/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 9:01 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/7/19 10:30 AM
 *
 */

package com.fleeca.fleecasdk.ui.invoicedetails

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kishan.contactstask.ui.contacts.ContactListViewModel

/**
 * Created by Pawan Kumar Sharma on 05-Nov-19.
 * Fleeca India Pvt Ltd
 * Android Developer
 * android_developer1@fleeca.in
 * +917737947610
 */
class ContactsVMFactory(var context: Context): ViewModelProvider.NewInstanceFactory() {
    override fun <ContactListViewModel : ViewModel?> create(modelClass: Class<ContactListViewModel>): ContactListViewModel {
        return ContactListViewModel(context) as ContactListViewModel
    }
}