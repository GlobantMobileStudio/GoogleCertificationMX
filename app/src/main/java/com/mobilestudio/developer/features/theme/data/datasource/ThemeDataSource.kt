package com.mobilestudio.developer.features.theme.data.datasource

import com.mobilestudio.developer.features.configuration.data.models.Theme

interface ThemeDataSource {
    fun getThemes(): List<Theme>
}