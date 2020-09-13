package com.mobilestudio.developer.features.configuration.domain.repository

import com.mobilestudio.developer.features.configuration.domain.domain.Configuration

interface ConfigurationRepository {
    fun loadConfiguration(): Configuration
}