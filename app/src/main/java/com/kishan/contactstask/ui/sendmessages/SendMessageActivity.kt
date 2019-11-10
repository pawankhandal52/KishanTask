/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 11:46 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 11:46 AM
 *
 */

package com.kishan.contactstask.ui.sendmessages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kishan.contactstask.R
import com.kishan.contactstask.database.AppDatabase
import com.kishan.contactstask.database.Message
import com.kishan.contactstask.databinding.ActivitySendMessageBinding
import com.kishan.contactstask.ui.base.BaseActivity
import com.kishan.contactstask.ui.contacts.model.Contact
import com.kishan.contactstask.ui.home.HomeActivity
import com.kishan.contactstask.utils.AppExecutors
import com.kishan.contactstask.utils.SELECTED_CONTACT

class SendMessageActivity : BaseActivity<ActivitySendMessageBinding>() {

    lateinit var viewModel: SendMessageViewModel
    override fun layoutRes(): Int  = R.layout.activity_send_message
    lateinit var  contact:Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setuptoolbar()
        if(intent.hasExtra(SELECTED_CONTACT)){
             contact = intent.getParcelableExtra<Contact>(SELECTED_CONTACT)!!
            viewModel = ViewModelProviders.of(this,SendMessageVMFactory(contact)).get(SendMessageViewModel::class.java)
            binding.viewmodel = viewModel
            binding.lifecycleOwner = this
            //binding.model = contact
        }else{
            Toast.makeText(this,"No details found",Toast.LENGTH_LONG).show()
            finish()
        }
        viewModel.loadingBar.observe(this, Observer { t: Boolean ->
            if(t){
                progressDialog?.show()
            }else{
                progressDialog?.hide()

            }
        })

        viewModel.message.observe(this, Observer { t: String ->
            binding.tvMessage.text = t
        })


        viewModel.messageResponse.observe(this, Observer { t: MessageResponse ->
            val message = Message()
            message.firstName = contact.firstName
            message.lastName = contact.lastName
            message.phoneNumber = contact.phoneNumber
            message.otp = viewModel.otp.value
            AppExecutors.getInstance().diskIO().execute(Runnable {
                AppDatabase.getDatabase(this).dao().insert(message)
            })

            Toast.makeText(this,"Message Sent: Message Id:${t.messages!!.get(0)!!.to}",Toast.LENGTH_LONG).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        })
        viewModel.errorMessage.observe(this, Observer { t: String ->
            showError(t)
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
