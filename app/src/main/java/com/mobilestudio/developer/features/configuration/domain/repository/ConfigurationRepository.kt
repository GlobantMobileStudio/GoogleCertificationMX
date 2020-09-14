package com.mobilestudio.developer.features.configuration.domain.repository

import com.mobilestudio.developer.features.configuration.domain.models.ConfigurationEntity

interface ConfigurationRepository {
    fun loadConfiguration(): ConfigurationEntity
}