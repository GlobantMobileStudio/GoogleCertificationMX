package com.mobilestudio.developer.features.configuration.data.datasource

import android.content.Context
import com.google.gson.Gson
import com.mobilestudio.developer.features.configuration.data.models.LocalConfiguration
import com.mobilestudio.developer.features.configuration.di.localConfiguration

class ConfigurationLocalDataSource(
    private val context: Context
) : ConfigurationDataSource {

    private fun getContent(): String =
        context.assets.open("data.json").bufferedReader().use { it.readText() }

    override fun loadConfiguration(): Boolean {
        val json = getContent()
        localConfiguration = Gson().fromJson(json, LocalConfiguration::class.java)
        return true
    }

}