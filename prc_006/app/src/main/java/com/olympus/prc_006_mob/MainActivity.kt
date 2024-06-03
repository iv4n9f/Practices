package com.olympus.prc_006_mob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var main_activity_mail_input: EditText
    lateinit var main_activity_password_input: EditText
    lateinit var main_activity_loggin_button: Button
    lateinit var main_activity_register_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initialize()
        setListeners()
    }

    fun initialize() {
        main_activity_mail_input = findViewById(R.id.main_activity_mail_input)
        main_activity_password_input = findViewById(R.id.main_activity_password_input)
        main_activity_loggin_button = findViewById(R.id.main_activity_loggin_button)
        main_activity_register_button = findViewById(R.id.main_activity_register_button)
    }

    fun setListeners() {
        main_activity_loggin_button.setOnClickListener() {
            val email = main_activity_mail_input.text.toString()
            val password = main_activity_password_input.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            if (email != "" && password != "") {
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                login()
                startActivity(intent)
            } else {
                Toast.makeText(this, R.string.loggin_toast_text, Toast.LENGTH_SHORT).show()
            }

        }
        main_activity_register_button.setOnClickListener() {
            val email = main_activity_mail_input.text.toString()
            val password = main_activity_password_input.text.toString()
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }

    fun login(){

    }

}