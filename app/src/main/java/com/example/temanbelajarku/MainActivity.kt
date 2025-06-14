package com.example.temanbelajarku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnHuruf = findViewById<Button>(R.id.btn_huruf)
        val btnAngka = findViewById<Button>(R.id.btn_angka)
        val btnWarna = findViewById<Button>(R.id.btn_warna)
        val btnAbout = findViewById<Button>(R.id.btn_about)

        btnHuruf.setOnClickListener {
            startActivity(Intent(this, HurufActivity::class.java))
        }

        btnAngka.setOnClickListener {
            startActivity(Intent(this, AngkaActivity::class.java))
        }

        btnWarna.setOnClickListener {
            startActivity(Intent(this, WarnaActivity::class.java))
        }

        btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}