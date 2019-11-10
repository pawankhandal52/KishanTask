/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 8:24 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 9/16/19 1:52 PM
 *
 */

package com.kishan.contactstask.utils

import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("bindServerDate")
fun bindServerDate(@NonNull textView: TextView, date: Date) {
    val dateFormat: SimpleDateFormat = SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH)

    val c = Calendar.getInstance()
    dateFormat.setTimeZone(TimeZone.getDefault())
    c.setTimeInMillis(date.getTime())
    textView.setText( dateFormat.format(c.getTimeInMillis()))


}


