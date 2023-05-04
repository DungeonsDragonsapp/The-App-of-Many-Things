package com.example.theappofmanythings

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.parse.ParseUser
import org.w3c.dom.Text

class ProfileDetail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_settings_page)

        val curusertext = findViewById<EditText>(R.id.Currentuser)
        val newusertext = findViewById<EditText>(R.id.NewUser)
        val confuservalue = findViewById<TextView>(R.id.textView19)
        val confusertext = findViewById<EditText>(R.id.ConfirmUser)
        val confpassvalue = findViewById<TextView>(R.id.textView17)
        val newpasstext = findViewById<EditText>(R.id.NewPass)
        val confpasstext = findViewById<EditText>(R.id.ConfirmPass)

        val userbut = findViewById<Button>(R.id.Userbutton)
        val passbut = findViewById<Button>(R.id.Passbutton)

        val currentuser = ParseUser.getCurrentUser().username
        val cur23pas23d25 = confpasstext.toString()
        curusertext.setText(currentuser)

        userbut.setOnClickListener {
            if (confusertext.text.toString().equals(newusertext.text.toString())) {
                ParseUser.getCurrentUser().username = confusertext.text.toString()
                ParseUser.getCurrentUser().saveInBackground()
                Toast.makeText(this, "Successful Username Update", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Error please enter the same username", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        newusertext.doAfterTextChanged {
        if(newusertext.text.toString() != null|| newusertext.text.toString() != " " ) {
                confusertext.setVisibility(View.VISIBLE)
                confuservalue.setVisibility(View.VISIBLE)
                userbut.setVisibility(View.VISIBLE)
            }
            else{
                confusertext.setVisibility(View.INVISIBLE)
                confuservalue.setVisibility(View.INVISIBLE)
                userbut.setVisibility(View.INVISIBLE)
            }
        }

        passbut.setOnClickListener{
            if (confpasstext == newpasstext){
                ParseUser.getCurrentUser().setPassword(cur23pas23d25)
                ParseUser.getCurrentUser().saveInBackground()
                Toast.makeText(this, "Successful Password Update", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                Toast.makeText(this, "Error please enter the same password", Toast.LENGTH_SHORT).show()
            }
        }

        newpasstext.doAfterTextChanged {
            if(newpasstext.text.toString() != null) {
                confpasstext.setVisibility(View.VISIBLE)
                confpassvalue.setVisibility(View.VISIBLE)
                passbut.setVisibility(View.VISIBLE)
            }
            else{
                confpasstext.setVisibility(View.INVISIBLE)
                confpassvalue.setVisibility(View.INVISIBLE)
                passbut.setVisibility(View.INVISIBLE)
            }
        }

    }
}