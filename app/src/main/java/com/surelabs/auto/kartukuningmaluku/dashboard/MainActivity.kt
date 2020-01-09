package com.surelabs.auto.kartukuningmaluku.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.akun.ProfileFragment
import com.surelabs.auto.kartukuningmaluku.dashboard.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
            .commitNow()
        supportActionBar?.title = getString(R.string.home)

        menu.setItemSelected(R.id.home)


        //bottom nav selected
        menu.setOnItemSelectedListener {
            when (it) {
                R.id.akun -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment()).commit()
                }
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commitNow()
                }
                R.id.layanan -> {

                }
                R.id.berita -> {

                }
            }
        }

    }


}
