package com.mobilestudio.developer.features.home.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilestudio.developer.features.theme.domain.usecase.GetThemesUseCase
import com.mobilestudio.developer.features.theme.presentation.mapper.ThemeEntityToModelMapper
import com.mobilestudio.developer.features.theme.presentation.model.ThemeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getThemesUseCase: GetThemesUseCase,
    private val mapper: ThemeEntityToModelMapper
) : ViewModel() {

    private val themes = MutableLiveData<List<ThemeModel>>()

    fun getThemes() = themes

    init {
        loadThemes()
    }

    private fun loadThemes() {
        viewModelScope.launch(Dispatchers.Main) {
            themes.value = withContext(Dispatchers.IO) {
                getThemesUseCase.getThemes()
            }.map {
                mapper.transform(it)
            }
        }
    }
}