package com.example.f.submission3.model

import com.google.gson.annotations.SerializedName

data class EventsItem(
	val homeBadgeTeam:String? = null,
	val awayBadgeTeam:String? = null,

	@SerializedName("intHomeShots")
	val intHomeShots: Any? = null,

	@SerializedName("strSport")
	val strSport: String? = null,

	@SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: Any? = null,

	@SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: Any? = null,

	@SerializedName("strHomeLineupForward")
	val strHomeLineupForward: Any? = null,

	@SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: Any? = null,

	@SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: Any? = null,

	@SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: Any? = null,

	@SerializedName("strHomeYellowCards")
	val strHomeYellowCards: Any? = null,

	@SerializedName("idHomeTeam")
	val idHomeTeam: String? = null,

	@SerializedName("intHomeScore")
	val intHomeScore: Any? = null,

	@SerializedName("dateEvent")
	val dateEvent: String? = null,

	@SerializedName("strAwayTeam")
	val strAwayTeam: String? = null,

	@SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: Any? = null,

	@SerializedName("strDate")
	val strDate: String? = null,

	@SerializedName("strHomeFormation")
	val strHomeFormation: Any? = null,

	@SerializedName("idAwayTeam")
	val idAwayTeam: String? = null,

	@SerializedName("strAwayRedCards")
	val strAwayRedCards: Any? = null,

	@SerializedName("intAwayShots")
	val intAwayShots: Any? = null,

	@SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: Any? = null,

	@SerializedName("strAwayLineupForward")
	val strAwayLineupForward: Any? = null,

	@SerializedName("strHomeRedCards")
	val strHomeRedCards: Any? = null,

	@SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: Any? = null,

	@SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: Any? = null,

	@SerializedName("strAwayFormation")
	val strAwayFormation: Any? = null,

	@SerializedName("strAwayYellowCards")
	val strAwayYellowCards: Any? = null,

	@SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: Any? = null,

	@SerializedName("strHomeTeam")
	val strHomeTeam: String? = null,

	@SerializedName("intAwayScore")
	val intAwayScore: Any? = null

)