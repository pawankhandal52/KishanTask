/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:45 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:45 PM
 *
 */

package com.kishan.contactstask.ui.contacts

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ContactListFragmentBinding
import com.kishan.contactstask.ui.base.BaseFragment
import com.kishan.contactstask.ui.contactDetails.ContactDetailsActivity
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.utils.SELECTED_CONTACT

class ContactListFragment : BaseFragment<ContactListFragmentBinding>() {
    override fun layoutRes(): Int = R.layout.contact_list_fragment

    companion object {
        fun newInstance() = ContactListFragment()
    }

    private lateinit var viewModel: ContactListViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rvContactList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, activity?.let { ContactsVMFactory(it) }).get(ContactListViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.error.observe(this, Observer { t: String? ->
            if(t!=null) showError(t) else hideError()
        })

        viewModel.selectedContact.observe(this, Observer { t: Contact ->
            showContactDetailsActivity(t)
        })

    }

    private fun showContactDetailsActivity(contact: Contact){
        val intent = Intent(activity,ContactDetailsActivity::class.java)
        intent.putExtra(SELECTED_CONTACT,contact)
        startActivity(intent)
    }

}
