package com.example.temanbelajarku.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.temanbelajarku.R
import com.example.temanbelajarku.models.Warna

class WarnaAdapter(
    private val warnaList: List<Warna>,
    private val onItemClick: (Warna) -> Unit
) : RecyclerView.Adapter<WarnaAdapter.WarnaViewHolder>() {

    inner class WarnaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvWarna: TextView = itemView.findViewById(R.id.tv_warna)
        private val viewColor: View = itemView.findViewById(R.id.view_color)

        fun bind(warna: Warna) {
            tvWarna.text = warna.nama
            viewColor.setBackgroundColor(ContextCompat.getColor(itemView.context, warna.colorResId))

            itemView.setOnClickListener {
                onItemClick(warna)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarnaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_warna, parent, false)
        return WarnaViewHolder(view)
    }

    override fun onBindViewHolder(holder: WarnaViewHolder, position: Int) {
        holder.bind(warnaList[position])
    }

    override fun getItemCount(): Int = warnaList.size
}