package com.mobilestudio.developer.features.theme.domain.model

class ThemeEntity(
    val title: String,
    val link: String,
    val topics: List<SubThemeEntity>? = null
)