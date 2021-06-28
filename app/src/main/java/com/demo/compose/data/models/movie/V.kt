package com.demo.compose.data.models.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class V(
    val i: IX,
    val id: String,
    val l: String,
    val s: String
):Parcelable