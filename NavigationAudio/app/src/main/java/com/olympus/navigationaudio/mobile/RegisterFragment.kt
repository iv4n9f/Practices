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

class RegisterFragment : Fragment() {

    private lateinit var fragmentRegisterUsernameInputText: TextInputEditText
    private lateinit var fragmentRegisterPasswordInputText: TextInputEditText
    private lateinit var fragmentRegisterLoginButton: Button
    private lateinit var fragmentRegisterRegisterButton: Button
    val registerData = LoginData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }

    fun initialize(view: View) {
        fragmentRegisterUsernameInputText = view.findViewById(R.id.fragmentRegisterUsernameInputText)
        fragmentRegisterPasswordInputText = view.findViewById(R.id.fragmentRegisterPasswordInputText)
        fragmentRegisterLoginButton = view.findViewById(R.id.fragmentRegisterLoginButton)
        fragmentRegisterRegisterButton = view.findViewById(R.id.fragmentRegisterRegisterButton)
        setListeners()
    }

    fun setListeners(){
        fragmentRegisterRegisterButton.setOnClickListener(){
            val username = fragmentRegisterUsernameInputText.text.toString()
            val password = fragmentRegisterPasswordInputText.text.toString()
            val registerStatus : Boolean = registerData.getRegisterValidation(username, password)
            if (registerStatus){
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                fragmentRegisterUsernameInputText.error = "Invalid Username"
                fragmentRegisterPasswordInputText.error = "Invalid Password"
            }
        }
        fragmentRegisterLoginButton.setOnClickListener(){
            val fragment = LoginFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_register, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}
