/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/9/19 7:57 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 10/22/19 7:18 PM
 *
 */

package com.kishan.contactstask.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class FragmentPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
       return mFragmentList.get(position)/*when (position){
           0-> return PaymentFragment()
           1->  return ReleaseVehicleFragment()
           else -> return OthersFragment()
       }*/
    }

    override fun getCount(): Int {
       return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
    
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
    
}
