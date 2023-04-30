package com.vishal.vision

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class spActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, home::class.java))
            finish()
        }, 2500)

    }
}