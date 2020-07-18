package com.mobilestudio.developer

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mobilestudio.developer.features.MainActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    private val runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
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
