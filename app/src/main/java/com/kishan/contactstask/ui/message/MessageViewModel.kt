/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:48 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:48 PM
 *
 */

package com.kishan.contactstask.ui.message

import android.content.Context
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kishan.contactstask.database.MessageDao
import com.kishan.contactstask.ui.base.BaseViewModel

class MessageViewModel(private val context:LifecycleOwner,private val dao: MessageDao) : BaseViewModel() {

    val messageListAdapter = MessageListAdapter()
    val noDataFound: MutableLiveData<Int> = MutableLiveData()
    val error = MutableLiveData<String>()

    init {
        loadMessage()
    }

     fun loadMessage() {
        error.value = null
        noDataFound.value = View.GONE
        val messageList = dao.getAllMessage()
         messageList.observe(context, Observer {messageList

                 if(messageList.value!!.isNotEmpty()){
                     messageListAdapter.updateMessageList(messageList.value!!)
                 }else{
                     error.value = null
                     noDataFound.value = View.VISIBLE
                 }
             })
         }



    }

