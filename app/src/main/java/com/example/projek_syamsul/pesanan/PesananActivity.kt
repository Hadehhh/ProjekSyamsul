package com.example.projek_syamsul.pesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.projek_syamsul.DashboardActivity
import com.example.projek_syamsul.R
import com.example.projek_syamsul.dapur.DapurActivity
import com.example.projek_syamsul.databinding.ActivityPesananBinding
import com.example.projek_syamsul.key.Key

class PesananActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPesananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Mahambara Cafe App"

        binding.idbtnLanjut.setOnClickListener(this)

        binding.bottomNavigation.menu.findItem(R.id.pesanan).setChecked(true)
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
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.idbtn_lanjut -> {
                val noMeja = binding.idedtNomermeja.text.toString()
                if (noMeja.isNotEmpty()) {
                    val intent = Intent(this, ListPesananActivity::class.java)
                    intent.putExtra(Key.KEY_NO_MEJA, noMeja)
                    startActivity(intent)
                } else {
                    binding.idedtNomermeja.error = "Tidak boleh kosong"
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}