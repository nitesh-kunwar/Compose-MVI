package com.demo.compose.data.models.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IX(
    val height: Int,
    val imageUrl: String,
    val width: Int
):Parcelable