/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 4:43 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 4:43 PM
 *
 */

package com.kishan.contactstask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kishan.contactstask.utils.Converter
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "message_table")
@TypeConverters(Converter::class)
data class Message(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "message_id")var id: Int =0,
                   var firstName:String? = null,
                   var lastName:String?=null,
                   var phoneNumber:String?=null,
                   var otp:String?=null,
                   var dataTime: Date?= Date(System.currentTimeMillis())
)