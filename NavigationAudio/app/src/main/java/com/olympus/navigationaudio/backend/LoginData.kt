package com.olympus.navigationaudio.backend

class LoginData {

    fun getLoginValidation(username : String, password : String): Boolean{
        if ((username != null) && (password != null)){
            return true
        } else {
            return false
        }
    }
}