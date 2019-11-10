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

class ContactViewModel:ViewModel() {
    private val firstName = MutableLiveData<String>()
    private val lastName = MutableLiveData<String>()
    private val phoneNumber = MutableLiveData<String>()

    /**
     * this function is used to bind the data which shows using mutable text in layout
     *
     * @param contact
     */
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