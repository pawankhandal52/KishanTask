/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 9:46 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 8:29 PM
 *
 */

package com.kishan.contactstask.ui.contacts.model

import android.os.Parcel
import android.os.Parcelable

data class Contact(
    var firstName: String?,
    var lastName: String?,
    var phoneNumber: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(firstName)
        writeString(lastName)
        writeString(phoneNumber)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Contact> = object : Parcelable.Creator<Contact> {
            override fun createFromParcel(source: Parcel): Contact = Contact(source)
            override fun newArray(size: Int): Array<Contact?> = arrayOfNulls(size)
        }
    }
}