package com.mobilestudio.developer.application

import android.app.Application
import com.mobilestudio.developer.features.configuration.di.configurationModule
import com.mobilestudio.developer.features.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import splashModule

class MobileStudioApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MobileStudioApplication)
            modules(
                listOf(
                    configurationModule,
                    splashModule,
                    homeModule
                )
            )
        }
    }

}