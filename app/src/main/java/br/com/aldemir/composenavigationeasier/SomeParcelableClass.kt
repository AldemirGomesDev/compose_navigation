package br.com.aldemir.composenavigationeasier

import android.os.Parcel
import android.os.Parcelable

data class SomeParcelableClass(
    val name: String,
    val address: String
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
}
