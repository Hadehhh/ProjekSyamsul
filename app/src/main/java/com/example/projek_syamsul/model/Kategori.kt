package com.example.projek_syamsul.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kategori(
    val kategori: String,
    val itemKategori: List<ItemKategori>
) : Parcelable

@Parcelize
data class ItemKategori(
    val image: String,
    val nama: String,
    val deskripsi: String,
    val harga: String
) : Parcelable