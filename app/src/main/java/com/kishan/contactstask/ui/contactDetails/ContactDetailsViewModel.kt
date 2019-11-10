/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 9:42 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 9:42 PM
 *
 */

package com.kishan.contactstask.ui.contactDetails

import androidx.lifecycle.MutableLiveData
import com.kishan.contactstask.ui.base.BaseViewModel
import com.kishan.contactstask.ui.contacts.model.Contact

/**
 * Created by Pawan Kumar Sharma on 09-Nov-19.
 * Fleeca India Pvt Ltd
 * Android Developer
 * android_developer1@fleeca.in
 * +917737947610
 */
class ContactDetailsViewModel:BaseViewModel() {

    val contact = MutableLiveData<Contact>()

    fun sendMessage(contact:Contact){
        this.contact.value = contact
    }
}