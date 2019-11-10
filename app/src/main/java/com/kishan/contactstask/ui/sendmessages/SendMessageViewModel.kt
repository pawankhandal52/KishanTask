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
import com.kishan.contactstask.BuildConfig.*
import com.kishan.contactstask.utils.WebUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.collections.HashMap


class SendMessageViewModel(var contact: Contact):BaseViewModel() {

    val message = MutableLiveData<String>()
    val messageResponse = MutableLiveData<MessageResponse>()
    val otp = MutableLiveData<String>()


    fun send(){

        sendMessage(MessageRequest(
            API_KEY,"ContactList","91${contact.phoneNumber}",
            message.value!!
        ))
    }


    init {
        buildMessage()
    }
    private fun buildMessage(){
        val number = randomNumber()
        otp.value = number
        message.value = "Hi ${contact.firstName} Your OTP is:${number}"
    }

    private fun randomNumber():String =  String.format("%04d", Random().nextInt(10000))

    private fun sendMessage(request: MessageRequest){
        val hashMap = HashMap<String,String>()
        hashMap.put("api_key",API_KEY)
        hashMap.put("api_secret",API_SECRECT)
        subscription = postApi.sendMessage(hashMap,WebUtil.toMap(request))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{onApiCallStart()}
            .doOnTerminate{onApiCallFinish()}
            .subscribe ({
                    t: MessageResponse? ->
                t?.let { onApiCallSuccess( it) }
            },{onApiCallError(it.localizedMessage)})
    }

    private fun onApiCallError(it: String) {
        errorMessage.value = it
        loadingBar.value = false

    }

    private fun onApiCallSuccess(response:MessageResponse){
        if(response.messages?.get(0)?.status =="0"){
            messageResponse.value = response
        }else{
            errorMessage.value = response.messages?.get(0)?.error
        }


    }


}