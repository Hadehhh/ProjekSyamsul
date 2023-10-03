package com.example.projek_syamsul

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    //Deklarasi variabel timer splash screennya
    private val SPLASH_TIME_OUT: Long = 2000 //delay 2 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Aktifkan progress bar/loading bar dan menjalankan main screen setelah timer splash screen habis
        Handler().postDelayed({
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
