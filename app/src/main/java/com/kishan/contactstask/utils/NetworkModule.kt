/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:36 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 10/24/19 3:21 PM
 *
 */

package com.kishan.contactstask.utils


import com.google.gson.GsonBuilder
import com.kishan.contactstask.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Module which provides all required dependencies about network
 */
object NetworkModule {
    private var retrofit: Retrofit? = null
    private var apiList: ApiList? = null

    fun getApis(): ApiList {
        if (retrofit == null) {
            setUpClient()
        }
        return retrofit!!.create(ApiList::class.java)
    }


    private fun setUpClient() {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded").build()
            chain.proceed(request)
        }

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(interceptor)
            .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        apiList = retrofit!!.create(ApiList::class.java)

    }


}