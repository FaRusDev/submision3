package com.example.f.submission3.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EventsItem(
        val favorite:String?,

	@SerializedName("idEvent")
	val idEvent:String?,

	@SerializedName("intHomeShots")
	val intHomeShots: String?,

	@SerializedName("strSport")
	val strSport: String?,

	@SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: String?,

	@SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: String?,

	@SerializedName("strHomeLineupForward")
	val strHomeLineupForward: String?,

	@SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: String?,

	@SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: String?,

	@SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: String?,

	@SerializedName("strHomeYellowCards")
	val strHomeYellowCards: String?,

	@SerializedName("idHomeTeam")
	val idHomeTeam: String?,

	@SerializedName("intHomeScore")
	val intHomeScore: String?,

	@SerializedName("dateEvent")
	val dateEvent: String?,

	@SerializedName("strAwayTeam")
	val strAwayTeam: String?,

	@SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: String?,

	@SerializedName("strDate")
	val strDate: String?,

	@SerializedName("strHomeFormation")
	val strHomeFormation: String?,

	@SerializedName("idAwayTeam")
	val idAwayTeam: String?,

	@SerializedName("strAwayRedCards")
	val strAwayRedCards: String?,

	@SerializedName("intAwayShots")
	val intAwayShots: String?,

	@SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: String?,

	@SerializedName("strAwayLineupForward")
	val strAwayLineupForward: String?,

	@SerializedName("strHomeRedCards")
	val strHomeRedCards: String?,

	@SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: String?,

	@SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: String?,

	@SerializedName("strAwayFormation")
	val strAwayFormation: String?,

	@SerializedName("strAwayYellowCards")
	val strAwayYellowCards: String?,

	@SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: String?,

	@SerializedName("strHomeTeam")
	val strHomeTeam: String?,

	@SerializedName("intAwayScore")
	val intAwayScore: String?,

    val homeBadgeTeam:String?,
    val awayBadgeTeam:String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(favorite)
        parcel.writeString(idEvent)
        parcel.writeString(intHomeShots)
        parcel.writeString(strSport)
        parcel.writeString(strHomeLineupDefense)
        parcel.writeString(strAwayLineupSubstitutes)
        parcel.writeString(strHomeLineupForward)
        parcel.writeString(strHomeGoalDetails)
        parcel.writeString(strAwayLineupGoalkeeper)
        parcel.writeString(strAwayLineupMidfield)
        parcel.writeString(strHomeYellowCards)
        parcel.writeString(idHomeTeam)
        parcel.writeString(intHomeScore)
        parcel.writeString(dateEvent)
        parcel.writeString(strAwayTeam)
        parcel.writeString(strHomeLineupMidfield)
        parcel.writeString(strDate)
        parcel.writeString(strHomeFormation)
        parcel.writeString(idAwayTeam)
        parcel.writeString(strAwayRedCards)
        parcel.writeString(intAwayShots)
        parcel.writeString(strAwayGoalDetails)
        parcel.writeString(strAwayLineupForward)
        parcel.writeString(strHomeRedCards)
        parcel.writeString(strHomeLineupGoalkeeper)
        parcel.writeString(strHomeLineupSubstitutes)
        parcel.writeString(strAwayFormation)
        parcel.writeString(strAwayYellowCards)
        parcel.writeString(strAwayLineupDefense)
        parcel.writeString(strHomeTeam)
        parcel.writeString(intAwayScore)
        parcel.writeString(homeBadgeTeam)
        parcel.writeString(awayBadgeTeam)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventsItem> {

        val favorite:String? = "fav"

        val ID_EVENT:String? = "iE"

        val intHomeShots: String? = "iHSh"

        val strSport: String? = "sS"

        val strHomeLineupDefense: String? = "sHLD"

        val strAwayLineupSubstitutes: String? = "sALS"

        val strHomeLineupForward: String? = "sHLF"

        val strHomeGoalDetails: String? = "sHGD"

        val strAwayLineupGoalkeeper: String? = "sALGK"

        val strAwayLineupMidfield: String? = "sALM"

        val strHomeYellowCards: String? = "sHYC"

        val IDHOMETEAM: String? = "iHT"

        val INTHOMESCORE: String? = "iHS"

        val dateEvent: String? = "dE"

        val STRAWAYTEAM: String? = "sAT"


        val strHomeLineupMidfield: String? = "sHLM"

        val strDate: String? = "sD"

        val strHomeFormation: String? = "sHF"

        val IDAWAYTEAM: String? = "iAT"

        val strAwayRedCards: String? = "sARC"

        val intAwayShots: String? = "iASh"

        val strAwayGoalDetails: String? = "sAGD"

        val strAwayLineupForward: String? = "sALF"

        val strHomeRedCards: String? = "sHRC"

        val strHomeLineupGoalkeeper: String? = "sHLGK"

        val strHomeLineupSubstitutes: String? = "sHLS"

        val strAwayFormation: String? = "sAF"

        val strAwayYellowCards: String? = "sAYC"

        val strAwayLineupDefense: String? = "sALD"

        val STRHOMETEAM: String? = "sHT"

        val INTAWAYSCORE: String? = "iAS"

        val homeBadgeTeam:String? = "hBT"
        val awayBadgeTeam:String? = "aBT"

        override fun createFromParcel(parcel: Parcel): EventsItem {
            return EventsItem(parcel)
        }

        override fun newArray(size: Int): Array<EventsItem?> {
            return arrayOfNulls(size)
        }
    }


}