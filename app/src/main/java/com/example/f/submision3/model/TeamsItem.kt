package com.example.f.submission3.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TeamsItem(

	@SerializedName("strTeam")
	val strTeam: String? = null,

	@SerializedName("strTeamBadge")
	val strTeamBadge: String? = null

) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(strTeam)
		parcel.writeString(strTeamBadge)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<TeamsItem> {
		override fun createFromParcel(parcel: Parcel): TeamsItem {
			return TeamsItem(parcel)
		}

		override fun newArray(size: Int): Array<TeamsItem?> {
			return arrayOfNulls(size)
		}
	}
}