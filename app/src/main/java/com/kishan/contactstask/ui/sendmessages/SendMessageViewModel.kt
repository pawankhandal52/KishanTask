/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 11:46 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 11:46 AM
 *
 */

package com.kishan.contactstask.ui.sendmessages

import androidx.lifecycle.MutableLiveData
import com.kishan.contactstask.ui.base.BaseViewModel
import com.kishan.contactstask.ui.contacts.model.Contact
import java.util.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class SendMessageViewModel(var contact: Contact):BaseViewModel() {

    val sendButtonClick = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun send(){

    }

    init {
        buildMessage()
    }
    private fun buildMessage(){
        message.value = "Hi ${contact.firstName} Your OTP is:${randomNumber()}"
    }

    private fun randomNumber():String =  String.format("%04d", Random().nextInt(10000))

}