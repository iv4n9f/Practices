package com.olympus.prc_006_mob

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson


class HomeActivity : AppCompatActivity() {
    lateinit var button_list :ImageButton
    lateinit var button_player :ImageButton
    lateinit var button_user :ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intializeComponents()
    }

    fun intializeComponents() {
        button_list = findViewById(R.id.button_list)
        button_player = findViewById(R.id.button_player)
        button_user = findViewById(R.id.button_user)
        setListeners()
    }

    fun setListeners(){
        button_list.setOnClickListener(){
            val navController = findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.homeScreenFragment)
        }
        button_player.setOnClickListener(){
            val navController = findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.homePlayerFragment)
        }
    }
}
