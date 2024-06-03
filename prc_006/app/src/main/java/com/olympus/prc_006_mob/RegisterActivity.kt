package com.olympus.prc_006_mob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    lateinit var register_mail_input: EditText
    lateinit var register_password_input: EditText
    lateinit var register_login_button: Button
    lateinit var register_register_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        initialize()
        setListeners()
    }

    fun initialize() {
        register_mail_input = findViewById(R.id.register_mail_input)
        register_password_input = findViewById(R.id.register_password_input)
        register_login_button = findViewById(R.id.register_login_button)
        register_register_button = findViewById(R.id.register_register_button)
    }

    fun setListeners() {
        register_register_button.setOnClickListener() {
            val email = register_mail_input.text.toString()
            val password = register_password_input.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            if (email != "" && password != "") {
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                register()
                startActivity(intent)
            } else {
                Toast.makeText(this, R.string.register_toast_text, Toast.LENGTH_SHORT).show()
            }

        }
        register_login_button.setOnClickListener() {
            val email = register_mail_input.text.toString()
            val password = register_password_input.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }

    fun register(){

    }
}