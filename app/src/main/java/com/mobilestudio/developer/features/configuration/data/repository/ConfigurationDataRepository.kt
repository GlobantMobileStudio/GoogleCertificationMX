package com.mobilestudio.developer.features.configuration.data.repository

import com.mobilestudio.developer.features.configuration.data.datasource.ConfigurationDataSource
import com.mobilestudio.developer.features.configuration.domain.domain.Configuration
import com.mobilestudio.developer.features.configuration.domain.repository.ConfigurationRepository

class ConfigurationDataRepository(
    private val configurationDataSource: ConfigurationDataSource
) : ConfigurationRepository {

    override fun loadConfiguration(): Configuration =
        Configuration(
            configurationDataSource.loadConfiguration()
        )

}