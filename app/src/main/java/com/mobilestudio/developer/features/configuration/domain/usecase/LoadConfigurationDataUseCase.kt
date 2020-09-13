package com.mobilestudio.developer.features.configuration.domain.usecase

import com.mobilestudio.developer.features.configuration.domain.domain.Configuration
import com.mobilestudio.developer.features.configuration.domain.repository.ConfigurationRepository

class LoadConfigurationDataUseCase(
    private val configurationRepository: ConfigurationRepository
) : LoadConfigurationUseCase {

    override fun loadConfiguration(): Configuration =
        configurationRepository.loadConfiguration()

}