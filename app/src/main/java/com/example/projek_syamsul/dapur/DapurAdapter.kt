package com.example.projek_syamsul.dapur

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_syamsul.databinding.ItemListDapurBinding
import com.example.projek_syamsul.model.PesananModel

class DapurAdapter(val onItemClickCallback: IOnItemClickCallback) : RecyclerView.Adapter<DapurAdapter.DapurViewHolder>() {

    var listDapur = ArrayList<PesananModel>()

    fun delete(index: Int) {
        this.listDapur.removeAt(index)
    }

    class DapurViewHolder(val binding: ItemListDapurBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DapurViewHolder {
        return DapurViewHolder(ItemListDapurBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DapurViewHolder, position: Int) {
        val data = listDapur[position]
        holder.binding.idtvNama.text = data.nama
        holder.binding.idtvNomerMeja.text = "No Meja\n${data.nomerMeja}"
        holder.binding.idtvHarga.text = "Rp. ${data.harga}"
        holder.binding.idtvWaktu.text = data.waktu

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data, position)
        }
    }

    override fun getItemCount(): Int {
        return listDapur.size
    }

    interface IOnItemClickCallback {
        fun onItemClicked(data: PesananModel, position: Int)
    }
}