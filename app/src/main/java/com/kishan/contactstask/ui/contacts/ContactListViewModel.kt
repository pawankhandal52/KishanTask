/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:45 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:45 PM
 *
 */

package com.kishan.contactstask.ui.contacts

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.kishan.contactstask.R
import com.kishan.contactstask.ui.base.BaseViewModel
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.utils.RecyclerViewClickListener
import java.io.InputStream

class ContactListViewModel(var context: Context) : BaseViewModel(),RecyclerViewClickListener<Contact> {


    val noDataFound: MutableLiveData<Int> = MutableLiveData()
    val contactListAdapter = ContactListAdapter(this)
    val error = MutableLiveData<String>()
    val selectedContact = MutableLiveData<Contact>()

    init {
        fetchContactsList()

    }

    private fun fetchContactsList(){
        error.value = null
        noDataFound.value = View.GONE
        val dataString = readJSONFromAsset()
        if(dataString!=null){
            val contact = GsonBuilder().create().fromJson(dataString , Array<Contact>::class.java).toList()
            if(contact.isNotEmpty()) contactListAdapter.updateContactList(contact) else noDataFound.value = View.VISIBLE
        }else{
            error.value = context.getString(R.string.unable_load_contact_list)
            noDataFound.value = View.VISIBLE
        }




    }

    private fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = context.assets.open("scratch.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun onRecyclerViewItemClick(_t: Contact) {
        selectedContact.value = _t
    }
}
