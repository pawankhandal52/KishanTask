/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 5:41 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 5:41 PM
 *
 */

package com.kishan.contactstask.utils

import androidx.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

public class Converter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = if (null == value) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

}