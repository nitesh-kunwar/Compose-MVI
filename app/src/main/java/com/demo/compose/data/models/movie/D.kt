package com.demo.compose.data.models.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class D(
    val i: I?,
    val id: String,
    val l: String,
    val s: String?,
    val v: List<V>?,
    val vt: Int
) : Parcelable