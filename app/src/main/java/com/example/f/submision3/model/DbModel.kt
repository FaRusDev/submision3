package com.example.f.submision3.model

import android.os.Parcel
import android.os.Parcelable

data class DbModel(
        val favorite:String?,
        val ID_EVENT:String?,
        val IDHOMETEAM: String?,
        val STRAWAYTEAM: String?,
        val STRHOMETEAM: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(favorite)
        parcel.writeString(ID_EVENT)
        parcel.writeString(IDHOMETEAM)
        parcel.writeString(STRAWAYTEAM)
        parcel.writeString(STRHOMETEAM)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DbModel> {
        val favorite:String? = "fav"
        val ID_EVENT:String? = "iE"
        val IDHOMETEAM: String? = "iHT"
        val STRAWAYTEAM: String? = "sAT"
        val STRHOMETEAM: String? = "sHT"
        override fun createFromParcel(parcel: Parcel): DbModel {
            return DbModel(parcel)
        }

        override fun newArray(size: Int): Array<DbModel?> {
            return arrayOfNulls(size)
        }
    }
}