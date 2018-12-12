package com.hjames.entertainme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Skip this page and open the hub
        launchEntertainmentHub()
    }

    private fun launchEntertainmentHub() {
        startActivity(Intent(this, EntertainmentHubActivity::class.java))
    }
}
