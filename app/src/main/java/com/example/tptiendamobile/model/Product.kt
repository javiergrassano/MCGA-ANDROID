package com.example.tptiendamobile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(val artist: Artist,
                   val title: String?,
                   val description: String?,
                   val artistId: String?,
                   val price: Float?,
                   val quantitySold: Int?,
                   val avgStars: Float?,
                   val image: String?) : Parcelable