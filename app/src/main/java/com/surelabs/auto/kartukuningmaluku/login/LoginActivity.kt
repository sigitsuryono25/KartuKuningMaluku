package com.surelabs.auto.kartukuningmaluku.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.login.ui.login.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }

}
