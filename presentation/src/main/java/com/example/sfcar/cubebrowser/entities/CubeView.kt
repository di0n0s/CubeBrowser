package com.example.sfcar.cubebrowser.entities

import android.os.Parcel
import android.os.Parcelable

data class CubeView(val id: Int = 0,
                    var title: String = "",
                    var url: String = "",
                    var position: Int = 0) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(title)
        writeString(url)
        writeInt(position)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CubeView> = object : Parcelable.Creator<CubeView> {
            override fun createFromParcel(source: Parcel): CubeView = CubeView(source)
            override fun newArray(size: Int): Array<CubeView?> = arrayOfNulls(size)
        }
    }
}