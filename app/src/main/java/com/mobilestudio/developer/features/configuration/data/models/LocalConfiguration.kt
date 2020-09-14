package com.mobilestudio.developer.features.configuration.data.models

import com.google.gson.annotations.SerializedName

class LocalConfiguration(
    @SerializedName("competencies")
    val competencies: List<Theme>
)