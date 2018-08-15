package com.example.sfcar.cubebrowser.entities

import android.os.Parcel
import android.os.Parcelable

data class CubeView(val id: Int,
                    var url: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CubeView> = object : Parcelable.Creator<CubeView> {
            override fun createFromParcel(source: Parcel): CubeView = CubeView(source)
            override fun newArray(size: Int): Array<CubeView?> = arrayOfNulls(size)
        }
    }
}