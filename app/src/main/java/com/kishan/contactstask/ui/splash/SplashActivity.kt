/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 6:39 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 6:35 PM
 *
 */

package com.kishan.contactstask.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ActivitySplashBinding
import com.kishan.contactstask.ui.base.BaseActivity
import com.kishan.contactstask.ui.home.HomeActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    lateinit var viewModel: SplashViewModel
    override fun layoutRes()  = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.nextButtonClick.observe(this, Observer { t: Boolean ->
            if (t){
                startHomeActivity()
            }
        })
    }

    /**
     * Function to call home screen
     *
     */
    fun startHomeActivity(){
        startActivity(Intent(this,HomeActivity::class.java))
    }
}
