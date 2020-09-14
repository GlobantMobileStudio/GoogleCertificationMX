package com.mobilestudio.developer.features.theme.data.repository

import com.mobilestudio.developer.features.theme.data.datasource.ThemeDataSource
import com.mobilestudio.developer.features.theme.data.mapper.ThemeToEntityMapper
import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity
import com.mobilestudio.developer.features.theme.domain.repository.ThemeRepository

class ThemeDataRepository(
    private val themeDataSource: ThemeDataSource,
    private val themeToEntityMapper: ThemeToEntityMapper
): ThemeRepository {

    override fun getThemes(): List<ThemeEntity> =
        themeDataSource.getThemes().map {
            themeToEntityMapper.transform(it)
        }

}