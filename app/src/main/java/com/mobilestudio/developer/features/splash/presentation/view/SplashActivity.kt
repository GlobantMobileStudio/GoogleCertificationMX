package com.mobilestudio.developer.features.splash.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilestudio.developer.extentions.observe
import com.mobilestudio.developer.features.configuration.domain.domain.Configuration
import com.mobilestudio.developer.features.main.presentation.view.MainActivity
import com.mobilestudio.developer.features.splash.presentation.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        observe(viewModel.getConfiguration(), ::manageConfiguration)
    }

    private fun manageConfiguration(configuration: Configuration) {
        if (configuration.enable) {
            goMain()
        }
    }

    private fun goMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
