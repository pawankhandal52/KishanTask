/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 3:07 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:07 PM
 *
 */

package com.kishan.contactstask.ui.sendmessages


data class MessageRequest(var api_key:String,
                          var from:String,
                          var to:String,
                          var text:String)