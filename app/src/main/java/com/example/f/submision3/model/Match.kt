package com.example.f.submission3.model

import com.google.gson.annotations.SerializedName

data class Match(

	@SerializedName("events")
	val events: List<EventsItem?>? = null
)