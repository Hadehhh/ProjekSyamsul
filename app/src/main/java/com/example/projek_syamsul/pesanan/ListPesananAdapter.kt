package com.example.projek_syamsul.pesanan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_syamsul.databinding.ItemListPesananBinding
import com.example.projek_syamsul.model.PesananModel

class ListPesananAdapter(private val onItemClickCallback: IOnItemClickCallback) : RecyclerView.Adapter<ListPesananAdapter.ListViewHolder>() {

    var listPesanan = ArrayList<PesananModel>()

    fun delete(index: Int) {
        this.listPesanan.removeAt(index)
    }

    class ListViewHolder(val binding: ItemListPesananBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemListPesananBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listPesanan[position]
        holder.binding.idtvNama.text = data.nama
        holder.binding.idtvHarga.text = "Rp. ${data.harga}"

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data, position)
        }


    }

    override fun getItemCount(): Int {
        return listPesanan.size
    }

    interface IOnItemClickCallback {
        fun onItemClicked(data: PesananModel, position: Int)
    }
}