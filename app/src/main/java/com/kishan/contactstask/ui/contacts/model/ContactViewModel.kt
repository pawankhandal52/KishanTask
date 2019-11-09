/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 8:29 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 8:29 PM
 *
 */

package com.kishan.contactstask.ui.contacts.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Pawan Kumar Sharma on 09-Nov-19.
 * Fleeca India Pvt Ltd
 * Android Developer
 * android_developer1@fleeca.in
 * +917737947610
 */
class ContactViewModel:ViewModel() {
    private val firstName = MutableLiveData<String>()
    private val lastName = MutableLiveData<String>()
    private val phoneNumber = MutableLiveData<String>()

    fun bind(contact:Contact){
        firstName.value = contact.firstName
        lastName.value = contact.lastName
        phoneNumber.value = contact.phoneNumber
    }

    fun getFirstName():MutableLiveData<String>{
        return firstName
    }
    fun getLastName():MutableLiveData<String>{
        return lastName
    }
    fun getPhoneNumber():MutableLiveData<String>{
        return phoneNumber
    }

}