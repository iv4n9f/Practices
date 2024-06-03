package com.olympus.navigationaudio.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olympus.navigationaudio.R

class MainActivity : AppCompatActivity() {

    private var loginStatus: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkLoginStatus(loginStatus)
    }

    private fun checkLoginStatus(status: Boolean) {
        if (!status) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, LoginFragment())
                .commit()
        }
    }
}
