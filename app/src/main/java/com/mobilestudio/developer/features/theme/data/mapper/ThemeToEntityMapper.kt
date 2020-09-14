package com.mobilestudio.developer.features.theme.data.mapper

import com.mobilestudio.developer.features.configuration.data.models.Theme
import com.mobilestudio.developer.features.theme.domain.model.SubThemeEntity
import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity

class ThemeToEntityMapper {

    fun transform(theme: Theme): ThemeEntity =
        with(theme) {
            ThemeEntity(
                title = title,
                link = link,
                topics = topics?.let { list ->
                    list.map {
                        SubThemeEntity(
                            title = it.title,
                            link = it.link,
                            className = it.className
                        )
                    }
                }
            )
        }
}