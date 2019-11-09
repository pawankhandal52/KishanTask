/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:34 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:33 PM
 *
 */

package com.kishan.contactstask.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kishan.contactstask.utils.ProgressDialog

abstract class BaseFragment<T:ViewDataBinding> : Fragment() {
    open lateinit var binding: T
    lateinit var progressDialog: ProgressDialog
    //open lateinit var viewModel: V
    private var errorSnackbar: Snackbar? = null
    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutRes(),container,false)
        progressDialog = ProgressDialog(this.activity!!)

        return binding.root
    }


    fun showError( errorMessage:String){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()
    }

    fun hideError(){
        errorSnackbar?.dismiss()
    }
}