package com.olympus.navigationaudio.mobile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.olympus.navigationaudio.R
import com.olympus.navigationaudio.backend.LoginData

class LoginFragment : Fragment() {

    private lateinit var fragmentLoginUsernameInputText: TextInputEditText
    private lateinit var fragmentLoginPasswordInputText: TextInputEditText
    private lateinit var fragmentLoginButton: Button
    private lateinit var fragmentRegisterButton: Button
    val loginData = LoginData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    fun initialize(view: View) {
        fragmentLoginUsernameInputText = view.findViewById(R.id.fragmentLoginUsernameInputText)
        fragmentLoginPasswordInputText = view.findViewById(R.id.fragmentLoginPasswordInputText)
        fragmentLoginButton = view.findViewById(R.id.fragmentLoginButton)
        fragmentRegisterButton = view.findViewById(R.id.fragmentRegisterButton)
        setListeners()
    }

    fun setListeners(){
        fragmentLoginButton.setOnClickListener(){
            val username = fragmentLoginUsernameInputText.text.toString()
            val password = fragmentLoginPasswordInputText.text.toString()
            val loginStatus : Boolean = loginData.getLoginValidation(username, password)
            if (loginStatus){
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                fragmentLoginUsernameInputText.error = "Invalid Username"
                fragmentLoginPasswordInputText.error = "Invalid Password"
            }

        }
        fragmentRegisterButton.setOnClickListener(){
            val fragment = RegisterFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_login, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}
