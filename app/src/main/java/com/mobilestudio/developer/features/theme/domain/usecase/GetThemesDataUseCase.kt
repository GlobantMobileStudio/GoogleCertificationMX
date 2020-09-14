package com.mobilestudio.developer.features.theme.domain.usecase

import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity
import com.mobilestudio.developer.features.theme.domain.repository.ThemeRepository

class GetThemesDataUseCase(
    private val themeRepository: ThemeRepository
) : GetThemesUseCase {

    override fun getThemes(): List<ThemeEntity> =
        themeRepository.getThemes()
}