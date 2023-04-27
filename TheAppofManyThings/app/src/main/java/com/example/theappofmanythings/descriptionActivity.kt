package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class descriptionActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.description_page)

        val personality = findViewById<EditText>(com.example.theappofmanythings.R.id.PersonalityInput).toString()
        val bonds = findViewById<EditText>(com.example.theappofmanythings.R.id.bonds).toString()
        val flaws = findViewById<EditText>(com.example.theappofmanythings.R.id.flaws).toString()
        val ideals = findViewById<EditText>(com.example.theappofmanythings.R.id.ideals).toString()
        val confirmButton = findViewById<Button>(com.example.theappofmanythings.R.id.button)

        confirmButton.setOnClickListener {
            character.setPersonality(personality)
            character.setBonds(bonds)
            character.setFlaws(flaws)
            character.setIdeals(ideals)

            val intent = Intent(this@descriptionActivity, CharacterMainActivity::class.java)
            startActivity(intent)
        }
    }
}
