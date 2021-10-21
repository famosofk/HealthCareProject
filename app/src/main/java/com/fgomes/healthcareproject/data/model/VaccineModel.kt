package com.fgomes.healthcareproject.data.model

import android.os.Parcel
import android.os.Parcelable

data class VaccineModel(
    override val id: String,
    override val title: String,
    override val date: String,
    override val doctor: String,
) : BaseModel, Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readString() ?: "",
        title = parcel.readString() ?: "",
        date = parcel.readString() ?: "",
        doctor = parcel.readString() ?: ""
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(doctor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VaccineModel> {
        override fun createFromParcel(parcel: Parcel): VaccineModel {
            return VaccineModel(parcel)
        }

        override fun newArray(size: Int): Array<VaccineModel?> {
            return arrayOfNulls(size)
        }
    }
}
