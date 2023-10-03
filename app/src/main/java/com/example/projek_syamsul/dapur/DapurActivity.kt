package com.example.projek_syamsul.dapur

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projek_syamsul.DashboardActivity
import com.example.projek_syamsul.R
import com.example.projek_syamsul.databinding.ActivityDapurBinding
import com.example.projek_syamsul.db.MappingHelper
import com.example.projek_syamsul.db.PesananHelper
import com.example.projek_syamsul.model.PesananModel
import com.example.projek_syamsul.pesanan.PesananActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DapurActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDapurBinding
    private lateinit var pesananHelper: PesananHelper
    private lateinit var adapterr: DapurAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDapurBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Mahambara Cafe App"

        binding.bottomNavigation.menu.findItem(R.id.dapur).setChecked(true)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    // Respond to navigation item 1 click
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.pesanan -> {
                    // Respond to navigation item 2 click
                    val intent = Intent(this, PesananActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.dapur -> {
                    // Respond to navigation item 2 click
                    val intent = Intent(this, DapurActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
        binding.bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    // Respond to navigation item 1 reselection
                }

                R.id.pesanan -> {
                    // Respond to navigation item 2 reselection
                }

                R.id.dapur -> {
                    // Respond to navigation item 2 reselection
                }
            }
        }

        adapterr = DapurAdapter(object : DapurAdapter.IOnItemClickCallback {
            override fun onItemClicked(data: PesananModel, position: Int) {
                showDialog(data, position)
            }
        })
        showListDapur()
    }

    fun showListDapur() {
        lifecycleScope.launch {
            pesananHelper = PesananHelper.getInstance(applicationContext)
            pesananHelper.open()

            val defferedPesanan = async(Dispatchers.IO) {
                val cursor = pesananHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }

            val dataDapur = defferedPesanan.await()
            if (dataDapur.size >0) {
                adapterr.listDapur = dataDapur
            } else {
                adapterr.listDapur = arrayListOf()
            }
            pesananHelper.close()
            showRvDapur()
        }
    }

    fun showRvDapur() {
        binding.idrvDapur.apply {
            adapter = adapterr
            layoutManager = LinearLayoutManager(this@DapurActivity)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun showDialog(data: PesananModel, position: Int) {
        val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Konfirmasi")
                .setMessage("Apakah menu sudah siap?")
                .setPositiveButton("Sudah") { _, _ ->
                    pesananHelper.open()
                    pesananHelper.deleteById(data.id.toString())
                    adapterr.delete(position)
                    showRvDapur()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.cancel()
                }
                .create()
                .show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}