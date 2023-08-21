package com.example.fininfocom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fininfocom.common.Validator
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    lateinit var username : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)


        username = findViewById(R.id.userNameEt)
        password = findViewById(R.id.passwordEt)
        loginButton = findViewById(R.id.loginBtn)

        loginButton.setOnClickListener {
            loginDetails()
        }
    }

    private fun loginDetails() {
        if(username.text.toString().isEmpty()){
            Toast.makeText(applicationContext,R.string.enter_userName,Toast.LENGTH_SHORT)
                .show()
        }else if (!Validator.isEmailValid(username.text.toString())) {
            Toast.makeText(applicationContext, R.string.enter_valid_email, Toast.LENGTH_SHORT)
                .show()
        }else if(password.text.toString().isEmpty()){
            Toast.makeText(applicationContext,R.string.enter_passWord,Toast.LENGTH_SHORT)
                .show()
        }else if(!Validator.isPasswordValid(password.text.toString())){
            Toast.makeText(applicationContext,R.string.enter_valid_password,Toast.LENGTH_SHORT)
                .show()
        }
        else{
            Toast.makeText(applicationContext, R.string.login_success, Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}