package com.example.tptiendamobile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(val firstName: String?,
                  val lastName: String?,
                  val fullName: String?,
                  val lifeSpan: String?,
                  val country: String?,
                  val description: String?,
                  val totalProducts: Int?,
                  val id: String?,
                  val flagImage: String?) : Parcelable