package com.mobilestudio.developer.features.theme.domain.usecase

import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity

interface GetThemesUseCase {
    fun getThemes(): List<ThemeEntity>
}