package com.example.sfcar.cubebrowser.entities

import android.os.Parcel
import android.os.Parcelable

data class BoardView(val id: Int,
                     val name: String,
                     val description: String,
                     val cubeList: ArrayList<CubeView>) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            ArrayList<CubeView>().apply { source.readList(this, CubeView::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(description)
        writeList(cubeList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BoardView> = object : Parcelable.Creator<BoardView> {
            override fun createFromParcel(source: Parcel): BoardView = BoardView(source)
            override fun newArray(size: Int): Array<BoardView?> = arrayOfNulls(size)
        }
    }
}