package com.example.theappofmanythings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val register = findViewById<View>(R.id.registerAccount) as TextView
        register.movementMethod = LinkMovementMethod.getInstance()
        register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        val login = findViewById<View>(R.id.loginButton) as Button
        login.movementMethod = LinkMovementMethod.getInstance()
        login.setOnClickListener {
            val username = findViewById<EditText>(R.id.inputUsername).text.toString()
            val password = findViewById<EditText>(R.id.inputPassword).text.toString()
            loginUser(username, password)
        }
    }

    private fun loginUser(username: String, password: String){
        ParseUser.logInInBackground(username, password, ({user, e->
            if(user!=null){
                Log.i("LoginActivity", "User Logged in")
                val intent = Intent(this@LoginActivity, CharacterCreationActivity::class.java)
                startActivity(intent)
            } else {
                e.printStackTrace()
                Toast.makeText(this, "Error Logging in", Toast.LENGTH_SHORT).show()
            }})
        )
    }
}