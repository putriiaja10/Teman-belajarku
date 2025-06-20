package com.example.temanbelajarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.adapters.HurufAdapter
import com.example.temanbelajarku.models.Huruf
import com.example.temanbelajarku.utils.SoundPlayer

class HurufActivity : AppCompatActivity() {
    private lateinit var soundPlayer: SoundPlayer
    private lateinit var hurufAdapter: HurufAdapter
    private lateinit var toolbarHuruf: Toolbar
    private lateinit var rvHuruf: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huruf)

        // Initialize views
        toolbarHuruf = findViewById(R.id.toolbar_huruf)
        rvHuruf = findViewById(R.id.rv_huruf)

        soundPlayer = SoundPlayer(this)

        setupRecyclerView()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarHuruf)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Belajar Huruf"
        toolbarHuruf.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupRecyclerView() {
        val hurufList = listOf(
            Huruf("A", R.drawable.huruf_a, R.raw.suara_a),
            Huruf("B", R.drawable.huruf_b, R.raw.suara_b),
            Huruf("C", R.drawable.huruf_c, R.raw.suara_c),
            Huruf("D", R.drawable.huruf_d, R.raw.suara_d),
            Huruf("E", R.drawable.huruf_f, R.raw.suara_e),
            Huruf("F", R.drawable.huruf_e, R.raw.suara_f),
            Huruf("G", R.drawable.huruf_g, R.raw.suara_g),
            Huruf("H", R.drawable.huruf_h, R.raw.suara_h),
            Huruf("I", R.drawable.huruf_i, R.raw.suara_i),
            Huruf("J", R.drawable.huruf_j, R.raw.suara_j),
            Huruf("K", R.drawable.huruf_k, R.raw.suara_k),
            Huruf("L", R.drawable.huruf_l, R.raw.suara_l),
            Huruf("M", R.drawable.huruf_m, R.raw.suara_m),
            Huruf("N", R.drawable.huruf_n, R.raw.suara_n),
            Huruf("O", R.drawable.huruf_o, R.raw.suara_o),
            Huruf("P", R.drawable.huruf_p, R.raw.suara_p),
            Huruf("Q", R.drawable.huruf_q, R.raw.suara_q),
            Huruf("R", R.drawable.huruf_r, R.raw.suara_r),
            Huruf("S", R.drawable.huruf_s, R.raw.suara_s),
            Huruf("T", R.drawable.huruf_t, R.raw.suara_t),
            Huruf("U", R.drawable.huruf_u, R.raw.suara_u),
            Huruf("V", R.drawable.huruf_v, R.raw.suara_v),
            Huruf("W", R.drawable.huruf_w, R.raw.suara_w),
            Huruf("X", R.drawable.huruf_x, R.raw.suara_x),
            Huruf("Y", R.drawable.huruf_y, R.raw.suara_y),
            Huruf("Z", R.drawable.huruf_z, R.raw.suara_z)
        )

        hurufAdapter = HurufAdapter(hurufList) { huruf ->
            soundPlayer.playSound(huruf.soundResId)
        }

        rvHuruf.apply {
            layoutManager = GridLayoutManager(this@HurufActivity, 3)
            adapter = hurufAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPlayer.release()
    }
}