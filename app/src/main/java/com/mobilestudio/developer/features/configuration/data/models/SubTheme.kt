package com.mobilestudio.developer.features.configuration.data.models

import com.google.gson.annotations.SerializedName

data class SubTheme(
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("class_name")
    val className: String
)