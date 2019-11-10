package com.kishan.contactstask.ui.sendmessages

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class MessagesItem(

	@field:SerializedName("message-price")
	val messagePrice: String? = null,

	@field:SerializedName("message-id")
	val messageId: String? = null,

	@field:SerializedName("to")
	val to: String? = null,

	@field:SerializedName("account-ref")
	val accountRef: String? = null,

	@field:SerializedName("remaining-balance")
	val remainingBalance: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("network")
	val network: String? = null,

	@field:SerializedName("error-text")
	val error: String? = null
)

/*
{
	"message-count": "1",
	"messages": [
	{
		"to": "919024253341",
		"status": "29",
		"error-text": "Non White-listed Destination - rejected"
	}
	]
}*/
