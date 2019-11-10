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
    var progressDialog: ProgressDialog? = null
    private var errorSnackbar: Snackbar? = null


    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutRes())
        progressDialog = ProgressDialog(this)
    }

    /**
     * Show Error on Activity using snack bar
     *
     * @param errorMessage
     */
     fun showError( errorMessage:String){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()
    }

    /**
     * Hide error
     *
     */
     fun hideError(){
        errorSnackbar?.dismiss()
    }


}