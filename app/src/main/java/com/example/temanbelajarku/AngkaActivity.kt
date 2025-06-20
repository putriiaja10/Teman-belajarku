package com.example.temanbelajarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.adapters.AngkaAdapter
import com.example.temanbelajarku.models.Angka
import com.example.temanbelajarku.utils.SoundPlayer

class AngkaActivity : AppCompatActivity() {
    private lateinit var soundPlayer: SoundPlayer
    private lateinit var angkaAdapter: AngkaAdapter
    private lateinit var toolbarAngka: Toolbar
    private lateinit var rvAngka: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angka)

        // Initialize views
        toolbarAngka = findViewById(R.id.toolbar_angka)
        rvAngka = findViewById(R.id.rv_angka)

        soundPlayer = SoundPlayer(this)

        setupRecyclerView()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarAngka)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Belajar Angka"
        toolbarAngka.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupRecyclerView() {
        val angkaList = listOf(
            Angka("1", R.drawable.angka_1, R.raw.suara_satu),
            Angka("2", R.drawable.angka_2, R.raw.suara_dua),
            Angka("3", R.drawable.angka_3, R.raw.suara_tiga),
            Angka("4", R.drawable.angka_4, R.raw.suara_empat),
            Angka("5", R.drawable.angka_5, R.raw.suara_lima),
            Angka("6", R.drawable.angka_6, R.raw.suara_enam),
            Angka("7", R.drawable.angka_7, R.raw.suara_tujuh),
            Angka("8", R.drawable.angka_8, R.raw.suara_delapan),
            Angka("9", R.drawable.angka_9, R.raw.suara_sembilan),
            Angka("10", R.drawable.angka_10, R.raw.suara_sepuluh)
        )

        angkaAdapter = AngkaAdapter(angkaList) { angka ->
            soundPlayer.playSound(angka.soundResId)
        }

        rvAngka.apply {
            layoutManager = GridLayoutManager(this@AngkaActivity, 3)
            adapter = angkaAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPlayer.release()
    }
}