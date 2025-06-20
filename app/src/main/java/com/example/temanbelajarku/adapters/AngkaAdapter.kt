package com.example.temanbelajarku.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.R
import com.example.temanbelajarku.models.Angka

class AngkaAdapter(
    private val angkaList: List<Angka>,
    private val onItemClick: (Angka) -> Unit
) : RecyclerView.Adapter<AngkaAdapter.AngkaViewHolder>() {

    inner class AngkaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvAngka: TextView = itemView.findViewById(R.id.tv_angka)
        private val ivGambar: ImageView = itemView.findViewById(R.id.iv_gambar)

        fun bind(angka: Angka) {
            tvAngka.text = angka.angka
            ivGambar.setImageResource(angka.gambarResId)

            itemView.setOnClickListener {
                onItemClick(angka)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AngkaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_angka, parent, false)
        return AngkaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AngkaViewHolder, position: Int) {
        holder.bind(angkaList[position])
    }

    override fun getItemCount(): Int = angkaList.size
}