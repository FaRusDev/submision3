package com.example.f.submission3.model

import com.google.gson.annotations.SerializedName

data class TeamsItem(

	@SerializedName("strTeam")
	val strTeam: String? = null,

	@SerializedName("strTeamBadge")
	val strTeamBadge: String? = null

)