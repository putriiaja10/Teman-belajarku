package com.example.temanbelajarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.temanbelajarku.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarAbout)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tentang Aplikasi"
        binding.toolbarAbout.setNavigationOnClickListener { onBackPressed() }
    }
}