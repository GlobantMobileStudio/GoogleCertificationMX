package com.mobilestudio.developer.features.home.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Theme(
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("topics")
    val topics: List<SubTheme>? = null
) : Parcelable {
    @Parcelize
    data class SubTheme(
        @SerializedName("title")
        val title: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("class_name")
        val className: String
    ) : Parcelable
}