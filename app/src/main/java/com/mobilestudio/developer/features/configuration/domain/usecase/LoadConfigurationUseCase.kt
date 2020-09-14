package com.mobilestudio.developer.features.configuration.domain.usecase

import com.mobilestudio.developer.features.configuration.domain.models.ConfigurationEntity

interface LoadConfigurationUseCase {
    fun loadConfiguration(): ConfigurationEntity
}