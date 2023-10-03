package com.example.projek_syamsul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projek_syamsul.dapur.DapurActivity
import com.example.projek_syamsul.databinding.ActivityDashboardBinding
import com.example.projek_syamsul.datamenu.DataMenu
import com.example.projek_syamsul.key.Key
import com.example.projek_syamsul.menu.KategoriActivity
import com.example.projek_syamsul.menu.ListKategoriActivity
import com.example.projek_syamsul.model.Kategori
import com.example.projek_syamsul.pesanan.PesananActivity

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDashboardBinding
    private var getNoMejaPesanan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Mahambara Cafe App"

        getNoMejaPesanan = intent.getStringExtra(Key.KEY_NO_MEJA)

        binding.idbtnMakanan.setOnClickListener(this)
        binding.idbtnMinuman.setOnClickListener(this)
        binding.idbtnDessert.setOnClickListener(this)

        binding.bottomNavigation.menu.findItem(R.id.menu).setChecked(true)
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
            R.id.idbtn_makanan -> {
                val intent = Intent(this, ListKategoriActivity::class.java)
                intent.putExtra(Key.KEY_KATEGORI, Kategori("Makanan", DataMenu.dataMakanan))
                intent.putExtra(Key.KEY_NO_MEJA, getNoMejaPesanan)
                startActivity(intent)
            }
            R.id.idbtn_minuman -> {
                val intent = Intent(this, ListKategoriActivity::class.java)
                intent.putExtra(Key.KEY_KATEGORI, Kategori("Minuman", DataMenu.dataMinuman))
                intent.putExtra(Key.KEY_NO_MEJA, getNoMejaPesanan)
                startActivity(intent)
            }
            R.id.idbtn_dessert -> {
                val intent = Intent(this, ListKategoriActivity::class.java)
                intent.putExtra(Key.KEY_KATEGORI, Kategori("Dessert", DataMenu.dataDessert))
                intent.putExtra(Key.KEY_NO_MEJA, getNoMejaPesanan)
                startActivity(intent)
            }
        }
    }
}
