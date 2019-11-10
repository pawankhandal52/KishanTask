/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 8:40 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 9/16/19 3:43 PM
 *  
 */

package com.kishan.contactstask.ui.contacts

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ItemContactsBinding
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.ui.contacts.model.ContactViewModel
import com.kishan.contactstask.utils.RecyclerViewClickListener

class ContactListAdapter( var itemClick:RecyclerViewClickListener<Contact>): RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private lateinit var contactList:List<Contact>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemContactsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_contacts, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int {
        return if(::contactList.isInitialized) contactList.size else 0
    }

    /**
     * to update the contact list
     *
     * @param contactList
     */
    fun updateContactList(contactList:List<Contact>){
        this.contactList = contactList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemContactsBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ContactViewModel()
        private var listener: RecyclerViewClickListener<Contact> = object :RecyclerViewClickListener<Contact>{
            override fun onRecyclerViewItemClick(_t: Contact) {
                itemClick.onRecyclerViewItemClick(_t)
            }
        }

        fun bind(post:Contact){
            viewModel.bind(post)
            binding.contactvm = viewModel
            binding.model = post
            binding.contactClick = listener
        }
    }
}