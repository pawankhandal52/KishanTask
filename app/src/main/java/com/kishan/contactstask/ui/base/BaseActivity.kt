/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:33 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:33 PM
 *
 */

package com.kishan.contactstask.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.kishan.contactstask.utils.ProgressDialog


abstract class BaseActivity<T: ViewDataBinding/*,V:BaseViewModel*/> : AppCompatActivity() {

    open lateinit var binding: T
     lateinit var progressDialog: ProgressDialog
    //open lateinit var viewModel: V
    private var errorSnackbar: Snackbar? = null


    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutRes())
        progressDialog = ProgressDialog(this)
    }

     fun showError( errorMessage:String,clickListener: View.OnClickListener){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction("Retry", clickListener)
        errorSnackbar?.show()
    }

     fun hideError(){
        errorSnackbar?.dismiss()
    }


}