/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 4:49 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 4:49 PM
 *
 */

package com.kishan.contactstask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MessageDao {
    /**
     * insert the Message in database
     *
     * @param message
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(message: Message)

    /**
     * Query to fetch all the message in order by datetime
     *
     * @return
     */
    @Query("SELECT * from message_table ORDER BY dataTime DESC")
    fun getAllMessage() : LiveData<MutableList<Message>>

}