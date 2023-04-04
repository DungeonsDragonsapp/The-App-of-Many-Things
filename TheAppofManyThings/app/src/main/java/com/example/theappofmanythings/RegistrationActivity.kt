package com.example.theappofmanythings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseUser

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)
        val register = findViewById<View>(R.id.registerButton) as Button
        register.movementMethod = LinkMovementMethod.getInstance()
        register.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(intent)
            val username = findViewById<EditText>(R.id.inputUsername).text.toString()
            val password = findViewById<EditText>(R.id.inputPassword).text.toString()
            val email = findViewById<EditText>(R.id.inputEmail).text.toString()
            RegisterUser(username, password, email)
        }
    }
    private fun RegisterUser(username: String, password: String, email: String) {

        val user = ParseUser()

        user.username = username
        user.setPassword(password)
        user.email = email

        user.signUpInBackground { e ->
            if (e == null) {
                // User successfully created new account
                Log.i("Register Successful", "User successfully signed up")
            } else {
                Toast.makeText(this, "Error signing up", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}

//