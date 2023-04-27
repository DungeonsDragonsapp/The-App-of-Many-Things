package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CharacterMainActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.character_mainpage)

        val statButton = findViewById<Button>(com.example.theappofmanythings.R.id.statButton)

        statButton.setOnClickListener {
            val intent = Intent(this@CharacterMainActivity, statChangeActivity::class.java)
            startActivity(intent)
        }
    }
}