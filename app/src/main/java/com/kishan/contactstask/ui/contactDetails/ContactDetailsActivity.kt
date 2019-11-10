/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 9:41 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 9:41 PM
 *
 */

package com.kishan.contactstask.ui.contactDetails

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ActivityContactDetailsBinding
import com.kishan.contactstask.ui.base.BaseActivity
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.ui.sendmessages.SendMessageActivity
import com.kishan.contactstask.utils.SELECTED_CONTACT

class ContactDetailsActivity : BaseActivity<ActivityContactDetailsBinding>() {
    lateinit var viewModel: ContactDetailsViewModel
    override fun layoutRes(): Int = R.layout.activity_contact_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setuptoolbar()
        if(intent.hasExtra(SELECTED_CONTACT)){
            val contact = intent.getParcelableExtra<Contact>(SELECTED_CONTACT)
            viewModel = ViewModelProviders.of(this).get(ContactDetailsViewModel::class.java)
            binding.model = contact
            binding.viewmodel = viewModel
            binding.lifecycleOwner = this

        }else{
            Toast.makeText(this,"No details found",Toast.LENGTH_LONG).show()
            finish()
        }

        viewModel.contact.observe(this, Observer { t: Contact ->
            startMessageScreen(t)
        })

    }

    /**
     * Set up toolbar
     *
     */
    private fun setuptoolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = getString(R.string.contact_details)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    /**
     * Start Message screen
     *
     * @param contact
     */
    private fun startMessageScreen(contact:Contact){
        val intent = Intent(this, SendMessageActivity::class.java)
        intent.putExtra(SELECTED_CONTACT,contact)
        startActivity(intent)
    }
}
