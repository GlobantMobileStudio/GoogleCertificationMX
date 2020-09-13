package com.mobilestudio.developer.features.configuration.domain.usecase

import com.mobilestudio.developer.features.configuration.domain.domain.Configuration

interface LoadConfigurationUseCase {
    fun loadConfiguration(): Configuration
}