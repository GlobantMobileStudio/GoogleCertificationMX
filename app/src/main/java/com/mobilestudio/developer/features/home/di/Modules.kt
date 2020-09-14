package com.mobilestudio.developer.features.home.di

import com.mobilestudio.developer.features.home.presentation.viewmodel.HomeViewModel
import com.mobilestudio.developer.features.theme.data.datasource.ThemeDataSource
import com.mobilestudio.developer.features.theme.data.datasource.ThemeLocalDataSource
import com.mobilestudio.developer.features.theme.data.mapper.ThemeToEntityMapper
import com.mobilestudio.developer.features.theme.data.repository.ThemeDataRepository
import com.mobilestudio.developer.features.theme.domain.repository.ThemeRepository
import com.mobilestudio.developer.features.theme.domain.usecase.GetThemesDataUseCase
import com.mobilestudio.developer.features.theme.domain.usecase.GetThemesUseCase
import com.mobilestudio.developer.features.theme.presentation.mapper.ThemeEntityToModelMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get(), get()) }
    single { ThemeEntityToModelMapper() }
    single { ThemeToEntityMapper() }
    factory { GetThemesDataUseCase(get()) as GetThemesUseCase }
    factory { ThemeDataRepository(get(), get()) as ThemeRepository }
    factory { ThemeLocalDataSource() as ThemeDataSource }
}