package com.domain.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Story (
    @SerializedName("items") val items: List<Items> = emptyList<Items>()
): Parcelable

@Parcelize
data class Items (
    @SerializedName("title") val title: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("link") val link: String,
    @SerializedName("is_priority") val isPriority: Boolean,
    @SerializedName("image") val image: String,
    @SerializedName("published") val published: String
): Parcelable