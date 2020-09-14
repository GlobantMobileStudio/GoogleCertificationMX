package com.mobilestudio.developer.features.configuration.di

import com.mobilestudio.developer.features.configuration.data.datasource.ConfigurationDataSource
import com.mobilestudio.developer.features.configuration.data.datasource.ConfigurationLocalDataSource
import com.mobilestudio.developer.features.configuration.data.models.LocalConfiguration
import com.mobilestudio.developer.features.configuration.data.repository.ConfigurationDataRepository
import com.mobilestudio.developer.features.configuration.domain.repository.ConfigurationRepository
import com.mobilestudio.developer.features.configuration.domain.usecase.LoadConfigurationDataUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var configurationModule = module {
    factory { LoadConfigurationDataUseCase(get()) }
    factory { ConfigurationDataRepository(get()) as ConfigurationRepository }
    factory { ConfigurationLocalDataSource(androidContext()) as ConfigurationDataSource }
}

lateinit var localConfiguration: LocalConfiguration