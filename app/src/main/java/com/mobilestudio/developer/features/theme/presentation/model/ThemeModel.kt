package com.mobilestudio.developer.features.theme.presentation.model

import android.os.Parcelable
import com.mobilestudio.developer.features.configuration.data.models.SubTheme
import kotlinx.android.parcel.Parcelize

@Parcelize
class ThemeModel(
    val title: String,
    val link: String,
    val topics: List<SubThemeModel> = emptyList()
) : Parcelable