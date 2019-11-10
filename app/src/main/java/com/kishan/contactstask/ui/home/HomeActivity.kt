/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:25 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/9/19 7:25 PM
 *
 */

package com.kishan.contactstask.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kishan.contactstask.utils.FragmentPagerAdapter
import com.kishan.contactstask.R
import com.kishan.contactstask.databinding.ActivityHomeBinding
import com.kishan.contactstask.ui.message.MessageFragment
import com.kishan.contactstask.ui.base.BaseActivity
import com.kishan.contactstask.ui.contacts.ContactListFragment



class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    lateinit var viewModel: HomeViewModel
    override fun layoutRes(): Int = R.layout.activity_home
    val TAG= HomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        setuptoolbar()
        binding.tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.viewpager))
        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        setupViewPager(binding.viewpager)

    }

    /**
     * Set up toolbar
     *
     */
    private fun setuptoolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = getString(R.string.app_name)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    /**
     * set up view pager
     *
     * @param viewPagerDailyTyre
     */
    private fun setupViewPager(viewPagerDailyTyre: ViewPager?) {
        val adapter = FragmentPagerAdapter(supportFragmentManager)
        adapter.addFragment(ContactListFragment.newInstance(),getString(R.string.contact_list))
        adapter.addFragment(MessageFragment.newInstance(),getString(R.string.messages))
        viewPagerDailyTyre?.adapter = adapter

    }
}
