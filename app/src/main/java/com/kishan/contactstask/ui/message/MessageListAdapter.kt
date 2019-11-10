/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 5:23 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 5:23 PM
 *
 */

package com.kishan.contactstask.ui.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kishan.contactstask.R
import com.kishan.contactstask.database.Message
import com.kishan.contactstask.databinding.ItemMessageListBinding


class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.ViewHolder>() {
    private lateinit var messageList: List<Message>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMessageListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_message_list, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int {
        return if (::messageList.isInitialized) messageList.size else 0
    }

    fun updateMessageList(message: List<Message>) {
        this.messageList = message
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMessageListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(message: Message) {
            binding.model = message
        }
    }
}