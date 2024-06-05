package com.olympus.navigationaudio.mobile

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.olympus.navigationaudio.R


class HomeActivity : AppCompatActivity() {

    lateinit var homeIconButtonMain: ImageButton
    lateinit var homeIconButtonHeadset: ImageButton
    lateinit var homeIconButtonUser: ImageButton
    lateinit var homeIconButtonSettings: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragment,ListFragment())
            .commit()
        initialize()
        changeColor(homeIconButtonMain)
    }


    fun initialize(){
        homeIconButtonMain = findViewById(R.id.homeIconButtonMain)
        homeIconButtonHeadset = findViewById(R.id.homeIconButtonHeadset)
        homeIconButtonUser = findViewById(R.id.homeIconButtonUser)
        homeIconButtonSettings = findViewById(R.id.homeIconButtonSettings)
        setListeners()
    }

    private fun setListeners() {

        homeIconButtonMain.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragment,ListFragment())
                .commit()
            buttonSelected(homeIconButtonMain)

        }
        homeIconButtonHeadset.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragment,PlayerFragment())
                .commit()
            buttonSelected(homeIconButtonHeadset)
        }
        homeIconButtonUser.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragment,UserFragment())
                .commit()
            buttonSelected(homeIconButtonUser)
        }
        homeIconButtonSettings.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragment,SettingsFragment())
                .commit()
            buttonSelected(homeIconButtonSettings)
        }
    }

    fun changeColor(button : ImageButton){
        val colorBlack = ContextCompat.getColor(this, R.color.main_black)
        button.imageTintList = ColorStateList.valueOf(colorBlack)
    }
    fun resetColor(button : ImageButton){
        val colorWhite = ContextCompat.getColor(this, R.color.main_white)
        button.imageTintList = ColorStateList.valueOf(colorWhite)
    }

    fun buttonSelected(button : ImageButton){
        resetColor(homeIconButtonMain)
        resetColor(homeIconButtonHeadset)
        resetColor(homeIconButtonUser)
        resetColor(homeIconButtonSettings)
        changeColor(button)
    }
}
