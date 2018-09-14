package com.example.f.submission3.model


import com.google.gson.annotations.SerializedName


data class Team(

	@SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)