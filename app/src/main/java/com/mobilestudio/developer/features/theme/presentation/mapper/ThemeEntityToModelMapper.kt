package com.mobilestudio.developer.features.theme.presentation.mapper

import com.mobilestudio.developer.features.theme.domain.model.ThemeEntity
import com.mobilestudio.developer.features.theme.presentation.model.SubThemeModel
import com.mobilestudio.developer.features.theme.presentation.model.ThemeModel

class ThemeEntityToModelMapper {
    fun transform(theme: ThemeEntity): ThemeModel =
        with(theme) {
            ThemeModel(
                title = title,
                link = link,
                topics = topics?.let { list ->
                    list.map {
                        SubThemeModel(
                            title = it.title,
                            link = it.link,
                            className = it.className
                        )
                    }
                } ?: emptyList()
            )
        }
}