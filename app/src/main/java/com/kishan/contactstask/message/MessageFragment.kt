/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:48 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:48 PM
 *
 */

package com.kishan.contactstask.message

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kishan.contactstask.R
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
        viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
