package com.mobilestudio.developer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mobilestudio.developer.features.overview.OverviewActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    private val runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext, OverviewActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 1000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}
