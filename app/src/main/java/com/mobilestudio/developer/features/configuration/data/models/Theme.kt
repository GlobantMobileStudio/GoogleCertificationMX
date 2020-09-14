package com.mobilestudio.developer.features.configuration.data.models

import com.google.gson.annotations.SerializedName

data class Theme(
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("topics")
    val topics: List<SubTheme>? = null
)