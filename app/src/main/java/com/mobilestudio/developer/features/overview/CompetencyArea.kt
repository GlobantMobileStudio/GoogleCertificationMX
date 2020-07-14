package com.mobilestudio.developer.features.overview

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompetencyArea(
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("topics")
    val topics: List<Topic>? = null
) : Parcelable  {
    @Parcelize
    data class Topic(
        @SerializedName("title")
        val title: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("class_name")
        val className: String
    ) : Parcelable
}