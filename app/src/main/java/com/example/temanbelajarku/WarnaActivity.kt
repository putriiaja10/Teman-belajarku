package com.example.temanbelajarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.adapters.WarnaAdapter
import com.example.temanbelajarku.models.Warna
import com.example.temanbelajarku.utils.SoundPlayer

class WarnaActivity : AppCompatActivity() {
    private lateinit var soundPlayer: SoundPlayer
    private lateinit var warnaAdapter: WarnaAdapter
    private lateinit var toolbarWarna: Toolbar
    private lateinit var rvWarna: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warna)

        // Initialize views
        toolbarWarna = findViewById(R.id.toolbar_warna)
        rvWarna = findViewById(R.id.rv_warna)

        soundPlayer = SoundPlayer(this)

        setupRecyclerView()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarWarna)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Belajar Warna"
        toolbarWarna.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupRecyclerView() {
        val warnaList = listOf(
            Warna("Merah", R.color.red, R.raw.suara_merah),
            Warna("Biru", R.color.blue, R.raw.suara_biru),
            Warna("Hijau", R.color.green, R.raw.suara_hijau),
            Warna("Ungu", R.color.purple, R.raw.suara_ungu)
        )

        warnaAdapter = WarnaAdapter(warnaList) { warna ->
            soundPlayer.playSound(warna.soundResId)
        }

        rvWarna.apply {
            layoutManager = GridLayoutManager(this@WarnaActivity, 2)
            adapter = warnaAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPlayer.release()
    }
}