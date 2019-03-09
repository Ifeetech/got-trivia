package com.adoranwodo.gottrivia

import kotlinx.android.synthetic.main.activity_splash.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.content.Intent

class SplashActivity : AppCompatActivity() {
    private var interval: Long = 100
    private var count: Int = 5
    private var mProgress: ProgressBar ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mProgress = splash_screen_progress_bar

        // Start lengthy operation in a background thread
        Thread(Runnable {
            showProgressBar()
            goToHome()
            finish()
        }).start()
    }

    private fun showProgressBar() {
        var progress = 0
        while (progress < 105) {
            try {
                //increment progress bar every 100ms
                Thread.sleep(interval)
                mProgress?.progress = progress
            } catch (e: Exception) {
                e.printStackTrace()
            }

            progress += count
        }
    }

    private fun goToHome() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}
