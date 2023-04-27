package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class descriptionActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_page)
        val confirmButton = findViewById<Button>(R.id.button)


        confirmButton.setOnClickListener {
            val personality = findViewById<EditText>(R.id.PersonalityInput).text.toString()
            val bonds = findViewById<EditText>(com.example.theappofmanythings.R.id.bonds).text.toString()
            val flaws = findViewById<EditText>(com.example.theappofmanythings.R.id.flaws).text.toString()
            val ideals = findViewById<EditText>(com.example.theappofmanythings.R.id.ideals).text.toString()



            Log.e("Input Fail?", personality + bonds + flaws+ ideals)
            character.setPersonality(personality)
            character.setBonds(bonds)
            character.setFlaws(flaws)
            character.setIdeals(ideals)
            character.saveInBackground()

            val intent = Intent(this@descriptionActivity, CharacterMainActivity::class.java)
            startActivity(intent)
        }
    }
}
