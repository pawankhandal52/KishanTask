/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 4:48 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 4:48 PM
 *
 */

package com.kishan.contactstask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kishan.contactstask.utils.Converter
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(Message::class), version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context /*scope: CoroutineScope*/): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "message_database"
                )//.addCallback(WordDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    //.allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}