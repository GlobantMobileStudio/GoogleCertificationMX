package com.mobilestudio.developer.features.splash.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilestudio.developer.features.configuration.domain.models.ConfigurationEntity
import com.mobilestudio.developer.features.configuration.domain.repository.ConfigurationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel(
    private val configurationRepository: ConfigurationRepository
) : ViewModel() {

    private var configuration = MutableLiveData<ConfigurationEntity>()

    fun getConfiguration() = configuration

    init {
        loadConfiguration()
    }

    private fun loadConfiguration() {
        viewModelScope.launch(Dispatchers.Main) {
            configuration.value = withContext(Dispatchers.IO) {
                configurationRepository.loadConfiguration()
            }
        }
    }

}