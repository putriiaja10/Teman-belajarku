package com.example.temanbelajarku.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.R
import com.example.temanbelajarku.models.Huruf

class HurufAdapter(
    private val hurufList: List<Huruf>,
    private val onItemClick: (Huruf) -> Unit
) : RecyclerView.Adapter<HurufAdapter.HurufViewHolder>() {

    inner class HurufViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvHuruf: TextView = itemView.findViewById(R.id.tv_huruf)
        private val ivGambar: ImageView = itemView.findViewById(R.id.iv_gambar)

        fun bind(huruf: Huruf) {
            tvHuruf.text = huruf.huruf
            ivGambar.setImageResource(huruf.gambarResId)

            itemView.setOnClickListener {
                onItemClick(huruf)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HurufViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_huruf, parent, false)
        return HurufViewHolder(view)
    }

    override fun onBindViewHolder(holder: HurufViewHolder, position: Int) {
        holder.bind(hurufList[position])
    }

    override fun getItemCount(): Int = hurufList.size
}