package com.mobilestudio.developer.features.home

import com.google.gson.annotations.SerializedName
import com.mobilestudio.developer.features.home.models.Theme

class LocalConfiguration(
    @SerializedName("competencies")
    val competencies: List<Theme>
)