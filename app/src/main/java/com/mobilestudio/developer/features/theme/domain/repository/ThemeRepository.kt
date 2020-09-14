package com.mobilestudio.developer.features.theme.domain.repository

import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity

interface ThemeRepository {
    fun getThemes(): List<ThemeEntity>
}