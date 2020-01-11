package com.surelabs.auto.kartukuningmaluku.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.berita.BeritaFragment
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.HomeFragment
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.layanan.LayananFragment
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.lowker.LowkerFragment
import com.surelabs.auto.kartukuningmaluku.login.ui.login.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
            .commitNow()
        setSupportActionBar(toolbar)
        titles.text = getString(R.string.home)

        menu.setItemSelected(R.id.home)


        //bottom nav selected
        menu.setOnItemSelectedListener {
            when (it) {
                R.id.akun -> {
                    titles.text = getString(R.string.akun)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LoginFragment()).commit()
                }
                R.id.home -> {
                    titles.text = getString(R.string.home)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commitNow()
                }
                R.id.layanan -> {
                    titles.text = getString(R.string.layanan)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LayananFragment())
                        .commitNow()
                }

                R.id.lowker -> {
                    titles.text = getString(R.string.lowker)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LowkerFragment())
                        .commitNow()
                }
                R.id.berita -> {
                    titles.text = getString(R.string.berita)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BeritaFragment())
                        .commitNow()
                }
            }
        }

    }


}
