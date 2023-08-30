package com.example.projek_syamsul.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projek_syamsul.databinding.ItemListKategoriBinding
import com.example.projek_syamsul.model.ItemKategori
import com.example.projek_syamsul.model.Kategori

class ListKategoriAdapter(val itemKategori: Kategori) : RecyclerView.Adapter<ListKategoriAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: IOnItemClickCallback

    fun onItemClick(itemClick: IOnItemClickCallback) {
        this.onItemClickCallback = itemClick
    }

    class ListViewHolder(val binding : ItemListKategoriBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemListKategoriBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = itemKategori.itemKategori[position]

        holder.binding.idnameJenis.text = data.nama
        Glide.with(holder.binding.root)
            .load(data.image)
            .fitCenter()
            .into(holder.binding.idimgItem)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data)
        }
    }

    override fun getItemCount(): Int {
        return itemKategori.itemKategori.size
    }

    interface IOnItemClickCallback {
        fun onItemClicked(item: ItemKategori)
    }
}