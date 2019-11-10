/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:48 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:48 PM
 *
 */

package com.kishan.contactstask.ui.message

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer

import com.kishan.contactstask.R
import com.kishan.contactstask.database.AppDatabase
import com.kishan.contactstask.database.Message
import com.kishan.contactstask.databinding.MessageFragmentBinding
import com.kishan.contactstask.ui.base.BaseFragment

class MessageFragment : BaseFragment<MessageFragmentBinding>() {
    override fun layoutRes(): Int  = R.layout.message_fragment

    companion object {
        fun newInstance() = MessageFragment()
    }

    private lateinit var viewModel: MessageViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,MessageVMFactory(this,activity!!.applicationContext)).get(MessageViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


    }

}
