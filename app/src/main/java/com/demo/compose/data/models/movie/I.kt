package com.demo.compose.data.models.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class I(
    val imageUrl: String
):Parcelable