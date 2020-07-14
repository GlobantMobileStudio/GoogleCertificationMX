package com.mobilestudio.developer.features.overview

import com.google.gson.annotations.SerializedName

class LocalConfiguration (
    @SerializedName("competencies")
    val competencies: List<CompetencyArea>
)