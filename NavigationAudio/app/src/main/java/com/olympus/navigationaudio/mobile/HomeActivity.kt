package com.olympus.navigationaudio.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olympus.navigationaudio.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragment, LoginFragment())
            .commit()
    }

}