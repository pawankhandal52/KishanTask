package com.kishan.contactstask.ui.sendmessages

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class MessageResponse(

	@field:SerializedName("message-count")
	val messageCount: Int? = null,

	@field:SerializedName("messages")
	val messages: List<MessagesItem?>? = null
)