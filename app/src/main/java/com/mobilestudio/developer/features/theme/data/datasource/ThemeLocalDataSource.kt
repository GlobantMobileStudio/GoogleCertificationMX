package com.mobilestudio.developer.features.theme.data.datasource

import com.mobilestudio.developer.features.configuration.data.models.Theme
import com.mobilestudio.developer.features.configuration.di.localConfiguration

class ThemeLocalDataSource : ThemeDataSource {

    override fun getThemes(): List<Theme> =
        localConfiguration.competencies

}