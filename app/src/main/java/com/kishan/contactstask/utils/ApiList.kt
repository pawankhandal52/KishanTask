/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:37 PM
 *
 */

package com.kishan.contactstask.utils

import com.kishan.contactstask.ui.sendmessages.MessageResponse
import io.reactivex.Observable
import retrofit2.http.*


interface ApiList {
    @JvmSuppressWildcards
    @FormUrlEncoded
    @POST(BASE_URL+"json")
    fun sendMessage(@QueryMap options:Map<String, String>,@FieldMap _objectMap: Map<String, Any?>
    ): Observable<MessageResponse>
}