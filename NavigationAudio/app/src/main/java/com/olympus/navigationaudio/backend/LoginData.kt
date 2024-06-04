package com.olympus.navigationaudio.backend

class LoginData {

    fun getLoginValidation(username : String, password : String): Boolean{
        if (username != ""){
            return true
        } else {
            return false
        }
    }

    fun getRegisterValidation(username : String, password : String): Boolean{
        if (username != ""){
            return true
        } else {
            return false
        }
    }
}