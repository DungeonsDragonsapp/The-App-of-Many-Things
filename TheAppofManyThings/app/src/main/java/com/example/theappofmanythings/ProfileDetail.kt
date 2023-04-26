package com.example.theappofmanythings

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileDetail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_settings_page)

        val curusertext = findViewById<EditText>(R.id.Currentuser)
        val newusertext = findViewById<EditText>(R.id.NewUser)
        val confusertext = findViewById<EditText>(R.id.ConfirmUser)
        val newpasstext = findViewById<EditText>(R.id.NewPass)
        val confpasstext = findViewById<EditText>(R.id.ConfirmPass)

        val userbut = findViewById<Button>(R.id.Userbutton)
        val passbut = findViewById<Button>(R.id.Passbutton)

        curusertext.setText(currentuser)

        userbut.setOnClickListener{
            if (confusertext == newusertext){

            }
            else {
                Toast.makeText(this, "Error Please enter the same username", Toast.LENGTH_SHORT).show()
            }
        }

        passbut.setOnClickListener{
            if (confpasstext == newpasstext){

            }
            else {
                Toast.makeText(this, "Error Please enter the same password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}