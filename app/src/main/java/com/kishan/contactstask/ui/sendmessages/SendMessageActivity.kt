/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 11:46 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 11:46 AM
 *
 */

package com.kishan.contactstask.ui.sendmessages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ActivitySendMessageBinding
import com.kishan.contactstask.ui.base.BaseActivity
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.utils.SELECTED_CONTACT

class SendMessageActivity : BaseActivity<ActivitySendMessageBinding>() {

    lateinit var viewModel: SendMessageViewModel
    override fun layoutRes(): Int  = R.layout.activity_send_message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setuptoolbar()
        if(intent.hasExtra(SELECTED_CONTACT)){
            val contact = intent.getParcelableExtra<Contact>(SELECTED_CONTACT)
            viewModel = ViewModelProviders.of(this,SendMessageVMFactory(contact!!)).get(SendMessageViewModel::class.java)
            binding.viewmodel = viewModel
            binding.lifecycleOwner = this
            //binding.model = contact
        }else{
            Toast.makeText(this,"No details found",Toast.LENGTH_LONG).show()
            finish()
        }

        viewModel.message.observe(this, Observer { t: String ->
            binding.tvMessage.text = t
        })
    }

    /**
     * Set up toolbar
     *
     */
    private fun setuptoolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = getString(R.string.send_message)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

}
