package com.example.projek_syamsul.pesanan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projek_syamsul.DashboardActivity
import com.example.projek_syamsul.databinding.ActivityListPesananBinding
import com.example.projek_syamsul.db.MappingHelper
import com.example.projek_syamsul.db.PesananHelper
import com.example.projek_syamsul.key.Key
import com.example.projek_syamsul.menu.KategoriActivity
import com.example.projek_syamsul.model.PesananModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ListPesananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListPesananBinding
    private lateinit var adapterr: ListPesananAdapter
    private lateinit var pesananHelper: PesananHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val getNoMeja = intent.getStringExtra(Key.KEY_NO_MEJA)!!

        binding.idbtnKirim.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.idbtnTambah.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra(Key.KEY_NO_MEJA, getNoMeja)
            startActivity(intent)
        }

        adapterr = ListPesananAdapter(object : ListPesananAdapter.IOnItemClickCallback {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemClicked(data: PesananModel, position: Int) {
                val dialog = AlertDialog.Builder(this@ListPesananActivity)
                    dialog.setTitle("Hapus")
                        .setMessage("Apakah anda yakin menghapus menu ini ?")
                        .setPositiveButton("YA") { _, _ ->
                            pesananHelper.open()
                            pesananHelper.deleteById(data.id.toString())
                            adapterr.delete(position)
                            showListPesanan()
                        }
                        .setNegativeButton("BATAL") { dialog, _ ->
                            dialog.cancel()
                        }
                        .create()
                        .show()
            }
        })
        showPesanan(getNoMeja)
    }

    fun showPesanan(noMeja: String) {
        lifecycleScope.launch {
            pesananHelper = PesananHelper.getInstance(applicationContext)
            pesananHelper.open()

            val defferedPesanan = async(Dispatchers.IO) {
                val cursor = pesananHelper.queryByNoMeja(noMeja)
                MappingHelper.mapCursorToArrayList(cursor)
            }

            val pesanan = defferedPesanan.await()
            if (pesanan.size > 0) {
                adapterr.listPesanan = pesanan
            } else {
                adapterr.listPesanan = arrayListOf()
            }
            pesananHelper.close()

            showListPesanan()
            supportActionBar?.title = "Pesanan No Meja $noMeja"
        }
    }

    fun showListPesanan() {
        binding.idrvListpesanan.apply {
            adapter = adapterr
            layoutManager = LinearLayoutManager(this@ListPesananActivity)
        }
        var total = 0
        for (item in adapterr.listPesanan) {
            total += item.harga.toInt()
        }
        binding.idtvTotalharga.text = "Total harga $total"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}